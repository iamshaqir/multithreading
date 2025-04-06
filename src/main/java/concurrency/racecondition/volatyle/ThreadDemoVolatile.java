package concurrency.racecondition.volatyle;

public class ThreadDemoVolatile {

    public static void show() {
        var status = new DownloadStatus();

        var thread1 = new Thread(new DownloadFileVolatile(status));
        var thread2 = new Thread(() -> {
            // if you add print statement in while loop it works perfectly, why??
            // Every call to println() flushes memory and forces the CPU to read the latest value of
            // from main memory as System.out.println() is a synchronized I/O operation.
            while (!status.isDone()) {
            }
            System.out.println("Total bytes: " + status.getTotalBytes());
        });
        thread1.start();
        thread2.start();
    }
}
