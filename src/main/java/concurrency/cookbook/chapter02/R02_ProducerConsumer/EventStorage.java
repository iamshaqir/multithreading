package concurrency.cookbook.chapter02.R02_ProducerConsumer;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class EventStorage {

    private static final int MAX = 10;
    private Queue<Date> storage;

    public EventStorage() {
        this.storage = new LinkedList<>();
    }

    public synchronized void set() {
        while (storage.size() >= 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        storage.add(new Date());
        System.out.printf("Set: %d\n", storage.size());
        notify();
    }

    public synchronized void get() {

        while (storage.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        String element = storage.poll().toString();
        System.out.printf("Get: %d: %s\n", storage.size(), element);
        notify();
    }
}
