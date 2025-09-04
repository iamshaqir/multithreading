package playground.r1.racecondition.basic;

import java.util.ArrayList;

public class Demo {

    public static void main(String[] args) {

        var downloadStatus = new DownloadStatus();
        var downloadFileTasks = new ArrayList<Thread>();

        // Created 10 Threads
        for (int i = 0; i < 10; i++) {
            var downloadFileTask = new Thread(new DownloadFileTask(downloadStatus));
            downloadFileTasks.add(downloadFileTask);
            downloadFileTask.start();
            System.out.println(downloadFileTask.getName() + " started.....");
        }

        // Joining threads
        for (var downloadFileTask : downloadFileTasks) {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting to join " + downloadFileTask.getName());
                downloadFileTask.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("File size: " + downloadStatus.getTotalBytes());
    }
}
