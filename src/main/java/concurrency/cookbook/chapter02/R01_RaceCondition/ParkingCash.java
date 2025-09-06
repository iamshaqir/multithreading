package concurrency.cookbook.chapter02.R01_RaceCondition;

public class ParkingCash {

    private static final int cost = 2;
    private long cash;

    public ParkingCash() {
        this.cash = 0;
    }

    public synchronized void pay() {
        cash += cost;
    }

    public void close() {
        System.out.println("--- Closing Accounting ---");
        synchronized (this) {
            System.out.printf("The total amount is : %d", cash);
            cash = 0;
        }
    }
}
