package playground.r1.racecondition.basic;

public class DownloadStatus {
    private int totalBytes;

    public int getTotalBytes() {
        return totalBytes;
    }

    public void increment() {
        totalBytes += 1;
        System.out.println(Thread.currentThread().getName() + " incremented " + totalBytes);
    }

    public synchronized void incrementSync() {
        totalBytes += 1;
        System.out.println(Thread.currentThread().getName() + " incremented " + totalBytes);
    }
}
