package playground.r1.racecondition.basic;

public class DownloadFileTask implements Runnable {

    private final DownloadStatus downloadStatus;

    public DownloadFileTask(DownloadStatus downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    public DownloadFileTask() {
        this.downloadStatus = new DownloadStatus();
    }

    public DownloadStatus getDownloadStatus() {
        return downloadStatus;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--- Downloading file ---");
        for (int i = 0; i < 100; i++) {
            downloadStatus.increment();
        }
    }
}
