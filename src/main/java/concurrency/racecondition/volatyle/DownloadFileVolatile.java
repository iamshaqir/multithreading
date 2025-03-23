package concurrency.racecondition.volatyle;

import concurrency.racecondition.volatyle.DownloadStatus;

public class DownloadFileVolatile implements Runnable {

    private final DownloadStatus status;

    public DownloadFileVolatile(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {

        System.out.printf("Downloading a file: %s \n", Thread.currentThread().getName());
        for (int i = 0; i < 1_000_000; i++) {
            if (Thread.currentThread().isInterrupted()) return;
            status.increment();
        }
        status.done();
        System.out.printf("Download complete: %s \n", Thread.currentThread().getName());
    }
}
