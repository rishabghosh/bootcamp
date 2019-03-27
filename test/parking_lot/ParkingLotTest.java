package parking_lot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    private Attendant attendant;

    @BeforeEach
    void setUp() {
        this.attendant = new Attendant(new Assistant(Display.get()));
    }

    @Test
    void shouldParkACarIfThereIsSpaceAvailable() throws ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot("P1", 3, attendant);
        assertTrue(parkingLot.park(new Car(1)));
    }

    @Test
    void shouldThrowExceptionIfNoSpaceIsAvailable() throws ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot("P1", 3, attendant);
        parkingLot.park(new Car(1));
        parkingLot.park(new Car(2));
        parkingLot.park(new Car(3));
        assertThrows(ParkingLotFullException.class, () -> parkingLot.park(new Car(4)));
    }

    @Test
    void shouldReturnTrueIfACarIsUnParked() throws ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot("P1", 3, attendant);
        parkingLot.park(new Car(1));
        parkingLot.park(new Car(2));
        parkingLot.park(new Car(3));
        assertTrue(parkingLot.unPark(1));
    }

    @Test
    void shouldNotifyTheAttendantWhenParkingLotIsFull() throws ParkingLotFullException {
        mockedAttendant mockedAttendant = new mockedAttendant(Display.get(), new Assistant(Display.get()));
        ParkingLot parkingLot = new ParkingLot("P1", 3, mockedAttendant);
        parkingLot.park(new Car(1));
        parkingLot.park(new Car(2));
        parkingLot.park(new Car(3));
        assertTrue(mockedAttendant.isNotifiedForFull);
    }

    @Test
    void shouldNotifyAttendantWhenParkingLotIsAvailable() throws ParkingLotFullException {
        mockedAttendant mockedattendant = new mockedAttendant(Display.get(), new Assistant(Display.get()));
        ParkingLot parkingLot = new ParkingLot("P1", 3, mockedattendant);
        parkingLot.park(new Car(1));
        parkingLot.park(new Car(2));
        parkingLot.park(new Car(3));
        parkingLot.unPark(1);
        assertTrue(mockedattendant.isNotifiedForAvailable);
    }

    @Test
    void shouldReturnFalseIfParkingLotIsEmpty() {
        ParkingLot parkingLot = new ParkingLot("P1", 3, attendant);
        assertFalse(parkingLot.unPark(1));
    }

    @Test
    void shouldNotifyAttendantToUpdateDisplayWhenCarIsParked() throws ParkingLotFullException {
        mockedAttendant attendant = new mockedAttendant(Display.get(), new Assistant(Display.get()));
        ParkingLot p1 = new ParkingLot("p1", 2, attendant);
        p1.park(new Car(2));
        assertTrue(attendant.isNotifiedForUpdatingDisplay);
    }

    @Test
    void attendantShouldGetNotifiedWhenTheTwentyPercentOfSizeIsLeftToPark() throws ParkingLotFullException {
        mockedAttendant attendant = new mockedAttendant(Display.get(), new Assistant(Display.get()));
        ParkingLot p1 = new ParkingLot("p1", 10, attendant);
        p1.park(new Car(1));
        p1.park(new Car(2));
        assertTrue(attendant.hasLesserCars);
    }
}


class mockedAttendant extends Attendant {
    boolean isNotifiedForFull;
    boolean isNotifiedForAvailable;
    boolean isNotifiedForUpdatingDisplay;
    boolean hasLesserCars;

    mockedAttendant(Display display, Assistant assistant) {
        super(assistant);
    }


    @Override
    void notifyWhenFull(ParkingLot parkingLot) {
        this.isNotifiedForFull = true;
    }

    @Override
    void notifyWhenAvailable(ParkingLot parkingLot) {
        this.isNotifiedForAvailable = true;
    }

    @Override
    void updateDisplay(String name, int noOfCars) {
        isNotifiedForUpdatingDisplay = true;
    }

    @Override
    void notifyForLessCars(ParkingLot parkingLot) {
        this.hasLesserCars = true;
    }
}