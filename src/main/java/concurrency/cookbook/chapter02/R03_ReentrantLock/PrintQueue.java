package concurrency.cookbook.chapter02.R03_ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

    private final Lock queueLock;

    public PrintQueue(boolean isFair) {
        queueLock = new ReentrantLock(isFair);
    }

    public void print(Object document) {
        queueLock.lock();
        try {
            long durationInMilliSeconds = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " +
                    (durationInMilliSeconds / 1000) + " seconds");
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            queueLock.unlock();
        }

        queueLock.lock();
        try {
            long durationInMilliSeconds = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " +
                    (durationInMilliSeconds / 1000) + " seconds");
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            queueLock.unlock();
        }
    }

}
