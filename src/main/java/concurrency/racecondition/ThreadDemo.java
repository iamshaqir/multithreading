package concurrency.racecondition;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo {

    /**
     * Here creating a single {@link DownloadStatus} Object and passing it all individual threads, sharing
     * the same resource which may cause <b>Race condition<b/>
     */
    public static void show() {
        var downloadStatus = new concurrency.racecondition.synchronization.DownloadStatus();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask(downloadStatus));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.printf("Total bytes: %d \n", downloadStatus.getTotalBytes());
        System.out.printf("Total Files: %d", downloadStatus.getTotalFiles());
    }
}
