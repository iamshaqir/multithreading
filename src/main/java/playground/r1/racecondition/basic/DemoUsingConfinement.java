package playground.r1.racecondition.basic;

import java.util.ArrayList;
import java.util.List;

public class DemoUsingConfinement {

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTask> taskList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            DownloadFileTask task = new DownloadFileTask();
            taskList.add(task);

            Thread thread = new Thread(task);
            threads.add(thread);
            thread.start();
            System.out.println(thread.getName() + " started ......");
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Integer bytes = taskList.stream()
                .map(DownloadFileTask::getDownloadStatus)
                .map(DownloadStatus::getTotalBytes)
                .reduce(Integer::sum)
                .orElseThrow();

        System.out.println("File size with confinement: " + bytes);


    }
}
