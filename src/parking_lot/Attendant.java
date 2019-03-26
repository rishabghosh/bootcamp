package parking_lot;

import java.util.ArrayList;
import java.util.List;

public class Attendant {
    private List<ParkingLot> parkingLots;
    private List<ParkingLot> availableParkingLots;

    Attendant() {
        this.parkingLots = new ArrayList<>();
        this.availableParkingLots = new ArrayList<>();
    }

    public void addParkingLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
        this.availableParkingLots.add(parkingLot);
    }

    void notifyWhenFull(ParkingLot parkingLot) {
        this.availableParkingLots.remove(parkingLot);
        System.out.println("Parking is full");
    }

    void notifyWhenAvailable(ParkingLot parkingLot) {
        this.availableParkingLots.add(parkingLot);
        System.out.println("Parking is available");
    }
}
