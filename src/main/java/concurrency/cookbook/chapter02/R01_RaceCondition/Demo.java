package concurrency.cookbook.chapter02.R01_RaceCondition;

public class Demo {

    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processors: " + availableProcessors);

        ParkingCash parkingCash = new ParkingCash();
        ParkingStats parkingStats = new ParkingStats(parkingCash);

        System.out.println("--- Parking Simulator ---");
        Thread[] threads = new Thread[availableProcessors];

        for (int i = 0; i < availableProcessors; i++) {
            Sensor sensor = new Sensor(parkingStats);
            Thread thread = new Thread(sensor);
            thread.start();
            threads[i] = thread;
        }

        for (int i = 0; i < availableProcessors; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.printf("Number of cars: %d\n", parkingStats.getNumberCars());
        System.out.printf("Number of motorcycles: %d\n", parkingStats.getNumberMotorcycles());
        parkingCash.close();
    }
}
