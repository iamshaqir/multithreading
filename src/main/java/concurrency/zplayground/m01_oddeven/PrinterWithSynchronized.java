package concurrency.zplayground.m01_oddeven;

public class PrinterWithSynchronized implements Printer {

    private volatile boolean isOddTurn = true;

    @Override
    public synchronized void printEven(int num) {
        // Is Odd true yes so go to wait state
        while (isOddTurn) {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting for ODD to print....");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + " " + num);
        isOddTurn = true;
        notify();
        System.out.println(Thread.currentThread().getName() + " notified to print ODD....");
    }

    @Override
    public synchronized void printOdd(int num) {
        // Is Odd false yes so go to wait state
        while (!isOddTurn) {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting for EVEN to print....");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + " " + num);
        isOddTurn = false;
        notify();
        System.out.println(Thread.currentThread().getName() + " notified to print EVEN....");
    }
}
