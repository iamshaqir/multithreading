package playground.r1.racecondition.volatilee;

public class VolatileStatus implements Runnable {

    public volatile boolean running = true;

    public boolean isRunning() {
        return running;
    }

    public void stopThread() {
        this.running = false;
    }

    @Override
    public void run() {
        while (running) {
            System.out.println(Thread.currentThread().getName() + " is running......");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(Thread.currentThread().getName() + " stopped......");
    }
}
