package concurrency.racecondition.confinement;

import concurrency.racecondition.basic.DownloadStatus;

public class DownloadFileConfinement implements Runnable {

    private final DownloadStatus status;

    public DownloadFileConfinement() {
        this.status = new DownloadStatus();
    }

    @Override
    public void run() {
        System.out.printf("Downloading a file: %s \n", Thread.currentThread().getName());
        for (int i = 0; i < 10_000; i++) {
            if (Thread.currentThread().isInterrupted()) return;
            status.incrementTotalBytes();
        }
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
