package parking_lot;

import java.util.ArrayList;
import java.util.List;

public class Attendant {
    private List<ParkingLot> availableParkingLots;
    private List<ParkingLot> unAvailableParkingLots;
    private Display display;

    Attendant(Display display) {
        this.display = display;
        this.availableParkingLots = new ArrayList<>();
        this.unAvailableParkingLots = new ArrayList<>();
    }

    void addParkingLot(ParkingLot parkingLot) {
        this.availableParkingLots.add(parkingLot);
    }

    void notifyWhenFull(ParkingLot parkingLot) {
        this.availableParkingLots.remove(parkingLot);
        this.unAvailableParkingLots.add(parkingLot);
        System.out.println("Parking is full");
    }

    void notifyWhenAvailable(ParkingLot parkingLot) {
        this.availableParkingLots.add(parkingLot);
        this.unAvailableParkingLots.remove(parkingLot);
        System.out.println("Parking is available");
    }

    void updateDisplay(String name, int noOfCars) {
        display.update(name, noOfCars);
    }


}
