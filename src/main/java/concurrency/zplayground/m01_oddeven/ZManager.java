package concurrency.zplayground.m01_oddeven;

/**
 * <b>Problem statement</b>: Print Even and Odd Numbers Using 2 Threads
 * <pre>
 *  - Print Odd numbers using one thread and Even numbers using other thread
 *  - Lock threads and use wait(), notify()/notifyAll() methods
 *  - Format should be ODD,EVEN,ODD,EVEN,ODD,.... or
 *  - 1 2 3 4 5 6 7 8 9 10
 * </pre>
 */
public class ZManager {

    public static void main(String[] args) {

        Printer withSynchronized = new PrinterWithSynchronized();
        Printer withSyncBlock = new PrinterWithSyncBlock();
        PrinterWithReentrantNCondition withReentrantNCondition = new PrinterWithReentrantNCondition();

        Thread odd = new Thread(new EvenOddThread(10, withSyncBlock, true));
        Thread even = new Thread(new EvenOddThread(10, withSyncBlock, false));

        odd.start();
        even.start();
    }
}