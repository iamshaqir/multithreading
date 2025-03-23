package concurrency.joinmethod;

public class DownloadStatus {

    private int totalBytes;

    public int getTotalBytes() {
        return totalBytes;
    }

    public void increment() {
        synchronized (this) {
            totalBytes++;
        }
    }
}
