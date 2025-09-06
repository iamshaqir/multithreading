package concurrency.cookbook.chapter02.R01_RaceCondition;

import java.util.concurrent.TimeUnit;

public class Sensor implements Runnable {

    private final ParkingStats parkingStats;

    public Sensor(ParkingStats parkingStats) {
        this.parkingStats = parkingStats;
    }

    private static void createDelay() {
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            parkingStats.carIn();
            parkingStats.carIn();
            createDelay();

            parkingStats.motorCycleIn();
            createDelay();
            
            parkingStats.MotorCycleOut();
            parkingStats.carOut();
            parkingStats.carOut();
        }
    }
}
