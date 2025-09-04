package playground.r1.racecondition.basic;

public class DemoRunnable {

    public static void main(String[] args) {
        DownloadStatus downloadStatus = new DownloadStatus();

        final int numThreads = 1000;

        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(downloadStatus::increment);
            threads[i] = thread;
            thread.start();
            System.out.println(thread.getName() + " started.....");
        }

        for (Thread thread : threads) {
            try {
                thread.join();
                System.out.println(Thread.currentThread().getName() + " waiting to join with: " + thread.getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Final count without syncronization: " + downloadStatus.getTotalBytes());

        downloadStatus = new DownloadStatus();
        threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(downloadStatus::incrementSync);
            threads[i] = thread;
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Final count with syncronization: " + downloadStatus.getTotalBytes());

    }
}
