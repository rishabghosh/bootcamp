package parking_lot;

import java.util.Arrays;

public class ParkingLot {
    private String name;
    private Car[] cars;
    private int currentParkingPosition;
    private int capacity;
    private Attendant attendant;
    private final double THRESHOLD_RATIO = 0.2;

    ParkingLot(String name, int capacity, Attendant attendant) {
        this.name = name;
        this.cars = new Car[capacity];
        this.currentParkingPosition = 0;
        this.capacity = capacity;
        this.attendant = attendant;
    }

    private ParkingLot(String name, int capacity, Attendant attendant, int currentParkingPosition, Car[] cars) {
        this.name = name;
        this.cars = cars;
        this.currentParkingPosition = currentParkingPosition;
        this.capacity = capacity;
        this.attendant = attendant;
    }

    ParkingLot getAPI() {
        Car[] newCars = new Car[this.cars.length];
        System.arraycopy(this.cars, 0, newCars, 0, this.cars.length);
        return new ParkingLot(this.name, this.capacity, this.attendant, this.currentParkingPosition, newCars);
    }

    private boolean isBelowThreshold() {
        return this.currentParkingPosition <= this.capacity * THRESHOLD_RATIO;
    }

    boolean park(Car car) throws ParkingLotFullException {
        if (isBelowThreshold()) attendant.notifyForLessCars(this.name);

        if (this.currentParkingPosition > this.capacity - 1) {
            throw new ParkingLotFullException();
        }

        if (this.currentParkingPosition == this.capacity - 1) {
            this.attendant.notifyWhenFull(this.name);
        }

        this.cars[currentParkingPosition] = car;
        currentParkingPosition++;
        this.attendant.updateDisplay(this.name, this.currentParkingPosition);
        return true;
    }


    boolean unPark(int id) {
        if (isBelowThreshold()) attendant.notifyForLessCars(this.name);

        if (currentParkingPosition <= 0) {
            return false;
        }

        currentParkingPosition--;
        this.attendant.updateDisplay(this.name, this.currentParkingPosition);

        for (int i = 0; i < this.cars.length; i++) {
            if (cars[i].getId() == id) {
                cars[i] = null;
                break;
            }
        }

        if (currentParkingPosition == this.capacity - 1) {
            attendant.notifyWhenAvailable(this.name);
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingLot)) return false;
        ParkingLot that = (ParkingLot) o;
        return currentParkingPosition == that.currentParkingPosition &&
                capacity == that.capacity &&
                Arrays.equals(cars, that.cars);
    }

    String getName() {
        return this.name;
    }
}
