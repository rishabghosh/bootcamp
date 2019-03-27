package parking_lot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    private MockAttendant mockAttendant;
    private ParkingLot parkingLot;

    @BeforeEach
    void setUp() {
        this.mockAttendant = new MockAttendant(new Assistant(Display.get()));
        parkingLot = new ParkingLot("P1", 3, mockAttendant);
    }

    @Test
    void shouldParkACarIfThereIsSpaceAvailable() throws ParkingLotFullException {
        assertTrue(parkingLot.park(new Car(1)));
    }

    @Test
    void shouldThrowExceptionIfNoSpaceIsAvailable() throws ParkingLotFullException {
        parkingLot.park(new Car(1));
        parkingLot.park(new Car(2));
        parkingLot.park(new Car(3));
        assertThrows(ParkingLotFullException.class, () -> parkingLot.park(new Car(4)));
    }

    @Test
    void shouldReturnTrueIfACarIsUnParked() throws ParkingLotFullException {
        parkingLot.park(new Car(1));
        parkingLot.park(new Car(2));
        parkingLot.park(new Car(3));
        assertTrue(parkingLot.unPark(1));
    }

    @Test
    void shouldNotifyTheAttendantWhenParkingLotIsFull() throws ParkingLotFullException {
        parkingLot.park(new Car(1));
        parkingLot.park(new Car(2));
        parkingLot.park(new Car(3));
        assertTrue(mockAttendant.isNotifiedForFull);
    }

    @Test
    void shouldNotifyAttendantWhenParkingLotIsAvailable() throws ParkingLotFullException {
        parkingLot.park(new Car(1));
        parkingLot.park(new Car(2));
        parkingLot.park(new Car(3));
        parkingLot.unPark(1);
        assertTrue(mockAttendant.isNotifiedForAvailable);
    }

    @Test
    void shouldReturnFalseIfParkingLotIsEmpty() {
        assertFalse(parkingLot.unPark(1));
    }

    @Test
    void shouldNotifyAttendantToUpdateDisplayWhenCarIsParked() throws ParkingLotFullException {
        parkingLot.park(new Car(2));
        assertTrue(mockAttendant.isNotifiedForUpdatingDisplay);
    }

    @Test
    void attendantShouldGetNotifiedWhenTheTwentyPercentOfSizeIsLeftToPark() throws ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot("parkingLot", 10, mockAttendant);
        parkingLot.park(new Car(1));
        parkingLot.park(new Car(2));
        assertTrue(mockAttendant.hasLesserCars);
    }
}


class MockAttendant extends Attendant {
    boolean isNotifiedForFull;
    boolean isNotifiedForAvailable;
    boolean isNotifiedForUpdatingDisplay;
    boolean hasLesserCars;

    MockAttendant(Assistant assistant) {
        super(assistant);
    }

    @Override
    void notifyWhenFull(String nameOfParkingLot) {
        this.isNotifiedForFull = true;
    }

    @Override
    void notifyWhenAvailable(String nameOfParkingLot) {
        this.isNotifiedForAvailable = true;
    }

    @Override
    void updateDisplay(String name, int noOfCars) {
        isNotifiedForUpdatingDisplay = true;
    }

    @Override
    void notifyForLessCars(String nameOfParkingLot) {
        this.hasLesserCars = true;
    }
}