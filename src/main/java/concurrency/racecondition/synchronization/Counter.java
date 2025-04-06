package concurrency.racecondition.synchronization;

public class Counter {

    private int count;

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }
}
