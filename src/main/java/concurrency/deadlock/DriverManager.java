package concurrency.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DriverManager {

    public static void main(String[] args) {

        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread thread1 = new Thread(new Runnable1(lock1, lock2));
        Thread thread2 = new Thread(new Runnable2(lock2, lock1));

        thread1.start();
        thread2.start();
    }
}
