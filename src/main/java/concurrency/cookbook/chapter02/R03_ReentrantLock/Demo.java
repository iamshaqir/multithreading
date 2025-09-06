package concurrency.cookbook.chapter02.R03_ReentrantLock;

public class Demo {

    public static void main(String[] args) {

        System.out.println("Running example with fair-mode = false");
        testPrintQueue(false);
        System.out.println("Running example with fair-mode = true");
        testPrintQueue(true);
    }

    private static void testPrintQueue(boolean isFair) {
        PrintQueue printQueue = new PrintQueue(isFair);

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue), "Thread " + i);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
