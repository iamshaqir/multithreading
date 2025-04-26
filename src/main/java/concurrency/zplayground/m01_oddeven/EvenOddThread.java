package concurrency.zplayground.m01_oddeven;

public class EvenOddThread implements Runnable {

    private final int maximum;

    private final Printer printer;

    private final boolean isOdd;

    public EvenOddThread(int maximum, Printer printer, boolean isOdd) {
        this.maximum = maximum;
        this.printer = printer;
        this.isOdd = isOdd;
    }

    @Override
    public void run() {
        int number = isOdd ? 1 : 2;
        System.out.println("NUMBER: " + number);
        while (number <= maximum) {
            if (isOdd) {
                printer.printOdd(number);
            } else {
                printer.printEven(number);
            }
            number += 2;
        }
    }
}
