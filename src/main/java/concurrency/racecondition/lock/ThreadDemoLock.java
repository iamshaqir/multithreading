package concurrency.racecondition.lock;


import java.util.ArrayList;
import java.util.List;

public class ThreadDemoLock {

    /**
     * Using lock mechanism with {@link java.util.concurrent.locks.ReentrantLock}, which does not allow any other
     * until Thread is free
     */
    public static void show() {
        var status = new DownloadStatus();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            var lockThread = new Thread(new DownloadFileTaskLock(status));
            lockThread.start();
            threads.add(lockThread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.printf("Total Bytes: %d", status.getTotalBytes());
    }
}
