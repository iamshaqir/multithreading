package concurrency.cookbook.chapter01;

import java.util.concurrent.TimeUnit;

public class T02_ThreadInterruption {

    public static void main(String[] args) {
        final String parent = "D:\\ws.intellijIDE\\multithreading\\src\\main";
        final String name = "log.txt";
        Thread thread = new Thread(new FileSearch(parent, name));
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.interrupt();
    }
}
