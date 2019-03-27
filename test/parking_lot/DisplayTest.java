package parking_lot;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DisplayTest {
    @Test
    void toStringMethodShouldReturnTheStatusOfParkingLots() throws ParkingLotFullException {
        Display display = Display.get();
        Attendant attendant = new Attendant(display);
        ParkingLot p1 = new ParkingLot("P1", 3, attendant);
        ParkingLot p2 = new ParkingLot("P2", 3, attendant);
        attendant.addParkingLot(p1);
        attendant.addParkingLot(p2);
        p1.park(new Car(1));
        p2.park(new Car(2));
        String actual = display.toString();
        String expected = "P1 1\nP2 1\n";
        assertEquals(expected, actual);
    }
}