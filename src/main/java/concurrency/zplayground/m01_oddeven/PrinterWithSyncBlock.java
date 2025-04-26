package concurrency.zplayground.m01_oddeven;

public class PrinterWithSyncBlock implements Printer {

    private volatile boolean isOddTurn = true;

    @Override
    public void printEven(int num) {
        // business logic
        synchronized (this) {
            // Odd's turn go to wait state
            while (isOddTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + " " + num);
            isOddTurn = true;
            notify();
        }
        // business logic
    }

    @Override
    public void printOdd(int num) {
        // some business logic
        synchronized (this) {
            // Even's turn go to wait state
            while (!isOddTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + " " + num);
            isOddTurn = false;
            notify();
        }
    }
}
