package concurrency.racecondition.lock;

public class DownloadFileTaskLock implements Runnable {
    private final DownloadStatus status;

    public DownloadFileTaskLock(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            System.out.printf("Downloading a file: %s \n", Thread.currentThread().getName());
            if (Thread.currentThread().isInterrupted()) return;
            status.increment();
        }
    }
}
