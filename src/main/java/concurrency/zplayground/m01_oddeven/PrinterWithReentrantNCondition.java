package concurrency.zplayground.m01_oddeven;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrinterWithReentrantNCondition implements Printer {
    private final Lock lock;
    private final Condition oddCondition;
    private final Condition evenCondition;
    private volatile boolean isOddTurn;

    public PrinterWithReentrantNCondition() {
        this.lock = new ReentrantLock();
        this.oddCondition = lock.newCondition();
        this.evenCondition = lock.newCondition();
        this.isOddTurn = true;
    }

    @Override
    public void printEven(int num) {
        lock.lock();
        try {
            while (isOddTurn) {
                evenCondition.await();
            }
            System.out.printf("%s %s\n", Thread.currentThread().getName(), num);
            isOddTurn = true;
            oddCondition.signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void printOdd(int num) {
        lock.lock();
        try {
            while (!isOddTurn) {
                oddCondition.await();
            }
            System.out.printf("%s %s\n", Thread.currentThread().getName(), num);
            isOddTurn = false;
            evenCondition.signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
