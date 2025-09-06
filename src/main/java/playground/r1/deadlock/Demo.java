package playground.r1.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {

    public static void main(String[] args) {

        Lock lockA = new ReentrantLock();
        Lock lockB = new ReentrantLock();

        Thread threadA = new Thread(new DeadLockExample(lockA, lockB));
        Thread threadB = new Thread(new DeadLockExample(lockB, lockA));

        threadA.start();
        threadB.start();
    }
}
