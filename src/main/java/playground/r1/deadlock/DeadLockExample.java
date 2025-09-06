package playground.r1.deadlock;

import java.util.concurrent.locks.Lock;

public class DeadLockExample implements Runnable {

    private final Lock lockA;
    private final Lock lockB;

    public DeadLockExample(Lock lockA, Lock lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        try {
            String name = Thread.currentThread().getName();
            System.out.println(name + " attempting to lock" + lockA);
            lockA.lock();
            Thread.sleep(5000);
            System.out.println(name + " attempting to lock B");
            lockB.lock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lockA.unlock();
            lockB.unlock();
        }
    }
}
