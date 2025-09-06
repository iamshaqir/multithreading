package concurrency.cookbook.chapter02.R03_ReentrantLock;

public class Job implements Runnable {

    private final PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
        printQueue.print(new Object());
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
    }
}
