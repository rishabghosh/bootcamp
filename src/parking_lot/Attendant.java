package parking_lot;

import java.util.HashMap;
import java.util.Map;

class Attendant {
    private Map<String, ParkingLot> availableParkingLots;
    private Map<String, ParkingLot> unAvailableParkingLots;
    private Map<String, ParkingLot> totalParkingLots;
    private Assistant assistant;

    Attendant(Assistant assistant) {
        this.availableParkingLots = new HashMap<>();
        this.unAvailableParkingLots = new HashMap<>();
        this.totalParkingLots = new HashMap<>();
        this.assistant = assistant;
    }

    void addParkingLot(ParkingLot parkingLot) {
        this.availableParkingLots.put(parkingLot.getName(), parkingLot);
        this.totalParkingLots.put(parkingLot.getName(), parkingLot);
    }

    private ParkingLot getParkingLotByName(String name){
        return this.totalParkingLots.get(name);
    }

    void notifyWhenFull(String nameOfParkingLot) {
        ParkingLot parkingLot = getParkingLotByName(nameOfParkingLot);
        this.availableParkingLots.remove(nameOfParkingLot);
        this.unAvailableParkingLots.put(nameOfParkingLot, parkingLot);
        System.out.println("Parking is full");
    }

    void notifyWhenAvailable(String nameOfParkingLot) {
        ParkingLot parkingLot = getParkingLotByName(nameOfParkingLot);
        this.availableParkingLots.put(nameOfParkingLot, parkingLot);
        this.unAvailableParkingLots.remove(nameOfParkingLot);
        System.out.println("Parking is available");
    }

    void updateDisplay(String name, int noOfCars) {
        this.assistant.updateDisplay(name, noOfCars);
    }

    void notifyForLessCars(String name) {
        System.out.println(name + " has less than 20% of cars");
    }
}
