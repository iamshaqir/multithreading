package concurrency.cookbook.chapter02.R01_RaceCondition;

public class ParkingStats {

    private final ParkingCash parkingCash;
    private final Object controlCars;
    private final Object controlMotorcycles;
    private long numOfCars;
    private long numOfMotorcycles;

    public ParkingStats(ParkingCash parkingCash) {
        this.numOfCars = 0;
        this.numOfMotorcycles = 0;
        this.parkingCash = parkingCash;
        this.controlCars = new Object();
        this.controlMotorcycles = new Object();
    }

    public void carIn() {
        synchronized (controlCars) {
            numOfCars += 1;
        }
    }

    public void carOut() {
        synchronized (controlCars) {
            numOfCars -= 1;
        }
        parkingCash.pay();
    }

    public void motorCycleIn() {
        synchronized (controlMotorcycles) {
            numOfMotorcycles += 1;
        }
    }

    public void MotorCycleOut() {
        synchronized (controlMotorcycles) {
            numOfMotorcycles -= 1;
        }
        parkingCash.pay();
    }

    public long getNumberCars() {
        return numOfCars;
    }

    public long getNumberMotorcycles() {
        return numOfMotorcycles;
    }
}
