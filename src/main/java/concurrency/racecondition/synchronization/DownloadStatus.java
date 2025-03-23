package concurrency.racecondition.synchronization;

public class DownloadStatus {

    private int totalBytes;
    private int totalFiles;

    // Monitor Objects
    private final Object bytes = new Object();
    private final Object files = new Object();

    public int getTotalBytes() {
        return totalBytes;
    }

    public int getTotalFiles() {
        return totalFiles;
    }

    public void incrementTotalBytes() {
        synchronized (bytes) {
            totalBytes++;
        }
    }

    public void incrementTotalFiles() {
        synchronized (files) {
            totalFiles++;
        }
    }
}
