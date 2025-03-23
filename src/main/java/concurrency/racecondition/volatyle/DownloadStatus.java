package concurrency.racecondition.volatyle;

public class DownloadStatus {

    private int totalBytes;
    private volatile boolean done = false;

    public int getTotalBytes() {
        return totalBytes;
    }

    public void increment() {
        synchronized (this) {
            totalBytes++;
        }
    }

    public boolean isDone() {
        return done;
    }

    public void done() {
        this.done = true;
    }
}
