package concurrency.joinmethod;

public class ThreadDemoJoin {


    public static void show() {

        var status = new DownloadStatus();
        var thread1 = new Thread(new DownloadFileTask(status));
        var thread2 = new Thread(new DownloadFileTask(status));

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // Main thread waits for thread1 to complete
            thread2.join(); // Main thread waits for thread2 to complete
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Total bytes: " + status.getTotalBytes());
    }
}
