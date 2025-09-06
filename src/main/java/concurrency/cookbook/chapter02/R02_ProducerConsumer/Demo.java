package concurrency.cookbook.chapter02.R02_ProducerConsumer;

import java.util.concurrent.TimeUnit;

public class Demo {

    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();

        Thread thread1 = new Thread(new Producer(eventStorage));
        Thread thread2 = new Thread(new Consumer(eventStorage));

        thread1.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread2.start();
    }
}
