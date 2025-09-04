package concurrency.racecondition.confinement;

import concurrency.racecondition.basic.DownloadStatus;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemoConfinement {

    /**
     * Creating an individual {@link DownloadStatus} Object within {@link  DownloadFileConfinement} Thread,
     * so that it shares a separate object for individual thread.
     * <p>
     * Maintaining a list of those objects and adding the total once operation is done
     */
    public static void show() {

        List<Thread> threads = new ArrayList<>();
        List<DownloadFileConfinement> withConfinements = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            var confinementTask = new DownloadFileConfinement();
            withConfinements.add(confinementTask);

            var thread = new Thread(confinementTask);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Integer totalBytes = withConfinements.stream()
                .map(t -> t.getStatus().getTotalBytes())
                .reduce(Integer::sum)
                .orElseThrow(() -> new RuntimeException("No data found"));

        System.out.printf("Total bytes: %d", totalBytes);
    }
}
