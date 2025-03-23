package concurrency.racecondition.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {

    private int totalBytes;

    private final Lock lock = new ReentrantLock();

    public int getTotalBytes() {
        return totalBytes;
    }

    public void increment() {
        lock.lock();
        try {
            totalBytes++;
        } finally {
            lock.unlock();
        }
    }
}
