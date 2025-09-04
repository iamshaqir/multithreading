package concurrency.racecondition.basic;


public class DownloadFileTask implements Runnable {
    private final DownloadStatus downloadStatus;

    public DownloadFileTask(DownloadStatus downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    @Override
    public void run() {
        System.out.printf("Downloading a file: %s \n", Thread.currentThread().getName());
        for (int i = 0; i < 10_000; i++) {
            if (Thread.currentThread().isInterrupted()) return;
            downloadStatus.incrementTotalBytes();
        }
    }
}
