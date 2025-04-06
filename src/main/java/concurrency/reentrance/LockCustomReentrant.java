package concurrency.reentrance;

public class LockCustomReentrant {

    private boolean isLocked = false;
    private Thread lockedThread = null;
    private int lockedThreadCount = 0;


    public synchronized void lock() {
        Thread currentThread = Thread.currentThread();
        while (isLocked && lockedThread != currentThread) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isLocked = true;
        lockedThread = currentThread;
        lockedThreadCount++;
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == lockedThread) {
            lockedThreadCount--;

            if (lockedThreadCount == 0) {
                isLocked = false;
                notifyAll();
            }
        }
    }
}
