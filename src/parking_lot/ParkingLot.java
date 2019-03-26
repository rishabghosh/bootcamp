package parking_lot;

import java.util.Arrays;

public class ParkingLot {
    private Car[] cars;
    private int currentParkingPosition;
    private int size;
    private Attendant attendant;

    ParkingLot(int size, Attendant attendant) {
        this.cars = new Car[size];
        this.currentParkingPosition = 0;
        this.size = size;
        this.attendant = attendant;
    }

    boolean park(Car car) throws ParkingLotFullException {
        if (this.currentParkingPosition > this.size - 1) {
            throw new ParkingLotFullException();
        }

        if (this.currentParkingPosition == this.size - 1) {
            this.attendant.notifyWhenFull(this);
        }

        this.cars[currentParkingPosition] = car;
        currentParkingPosition++;
        return true;
    }

    boolean unpark(int id) {
        if (currentParkingPosition <= 0) {
            return false;
        }
        currentParkingPosition--;
        for (int i = 0; i < this.cars.length; i++) {
            if (cars[i].getId() == id) {
                cars[i] = null;
                break;
            }
        }
        if (currentParkingPosition == this.size - 1) {
            attendant.notifyWhenAvailable(this);
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingLot)) return false;
        ParkingLot that = (ParkingLot) o;
        return currentParkingPosition == that.currentParkingPosition &&
                size == that.size &&
                Arrays.equals(cars, that.cars);
    }
}
