package playground.r1.racecondition.volatilee;

public class VolatileDemo {

    public static void main(String[] args) {
        VolatileStatus volatileStatus = new VolatileStatus();

        Thread thread1 = new Thread(volatileStatus);
        Thread thread2 = new Thread(() -> {
            while (volatileStatus.isRunning()) {
            }
            System.out.println(thread1.getName() + " stopped using volatile....");
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("--- Disabling volatile flag ---");
        volatileStatus.stopThread();
        System.out.println("Volatile flag: " + volatileStatus.isRunning());
        System.out.println("Is " + thread2.getName() + " Alive: " + thread2.isAlive());
    }
}
