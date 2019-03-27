package parking_lot;

import java.util.ArrayList;
import java.util.List;

class Attendant {
    public boolean isNotifiedForThresholdLimit;
    private List<ParkingLot> availableParkingLots;
    private List<ParkingLot> unAvailableParkingLots;
    private Assistant assistant;

    Attendant(Assistant assistant) {
        this.availableParkingLots = new ArrayList<>();
        this.unAvailableParkingLots = new ArrayList<>();
        this.assistant = assistant;
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
        this.assistant.updateDisplay(name, noOfCars);
    }

    void notifyForLessCars(ParkingLot parkingLot) {
        System.out.println(parkingLot + "has less than 20% of cars");
    }
}
