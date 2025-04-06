package concurrency.reentrance;


/**
 * With this approach we cannot make Lock as reentrant as it won't allow to access synchronized blocks/methods to
 * run on same monitor object because of `isLocked`, alternate option
 */
public class LockCustom {

    private boolean isLocked = false;

    public synchronized void lock() {
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notifyAll();
    }
}
