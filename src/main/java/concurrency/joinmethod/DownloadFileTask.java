package concurrency.joinmethod;

public class DownloadFileTask implements Runnable {
    private final DownloadStatus status;

    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started.");
        for (int i = 0; i < 10_000; i++) {
            status.increment();
        }
        System.out.println(Thread.currentThread().getName() + " finished.");
    }
}
