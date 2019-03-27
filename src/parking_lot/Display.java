package parking_lot;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Display {
    private Map<String, Integer> parkingLotsStatus;
    private static Display instance;

    private Display() {
        this.parkingLotsStatus = new HashMap<>();
    }

    void update(String name, int noOfCars) {
        this.parkingLotsStatus.put(name, noOfCars);
    }

    static Display get() {
        if (instance == null) {
            instance = new Display();
        }
        return instance;
    }


    @Override
    public String toString() {
        Set<String> allParkingLots = this.parkingLotsStatus.keySet();
        StringBuilder status = new StringBuilder();
        for (String parkingLot : allParkingLots) {
            status.append(parkingLot).append(" ").append(this.parkingLotsStatus.get(parkingLot)).append("\n");
        }
        return status.toString();
    }
}
