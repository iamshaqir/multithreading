package concurrency.racecondition.synchronization;


public class WriteReadThread {

    public static void main(String[] args) {

        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started...");
            for (int i = 0; i < 10_000; i++) {
                counter.increment();
            }
            System.out.println(Thread.currentThread().getName() + " finished...");
            System.out.println("Final Count: " + counter.getCount());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started...");
            for (int i = 0; i < 5; i++) {
                System.out.println("Count: " + counter.getCount());
            }
            System.out.println(Thread.currentThread().getName() + " finished...");
        });

        thread1.start();
        thread2.start();
    }
}
