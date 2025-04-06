package concurrency.racecondition.synchronization;


public class SynchronizedExchangerMain {


    public static void main(String[] args) {

        SynchronizedExchanger synchronizedExchanger = new SynchronizedExchanger();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + " => " + i);
                synchronizedExchanger.setObject("" + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + synchronizedExchanger.getObject());
            }
        });

        thread1.start();
        thread2.start();
    }
}
