package concurrency.deadlock;

import java.util.concurrent.locks.Lock;

public class Runnable1 implements Runnable {

    private final Lock lock1;
    private final Lock lock2;

    public Runnable1(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            System.out.println(threadName + " Attempting to lock Lock 1 ::::");
            lock1.lock();
            System.out.println(threadName + " locked Lock 1");
            Thread.sleep(3000);
            System.out.println(threadName + " Attempting to lock Lock 2 ::::");
            lock2.lock();
            System.out.println(threadName + " locked Lock 2");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(threadName + " unlocking Lock 1");
            lock1.unlock();
            System.out.println(threadName + " unlocking Lock 2");
            lock2.unlock();
        }
    }
}
