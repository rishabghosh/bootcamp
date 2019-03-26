package parking_lot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    Attendant attendant;

    @BeforeEach
    void setUp() {
        this.attendant = new Attendant();
    }

    @Test
    void shouldParkACarIfThereIsSpaceAvailable() throws ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(3, attendant);
        assertTrue(parkingLot.park(new Car()));
    }

    @Test
    void shouldThrowExceptionIfNoSpaceIsAvailable() throws ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(3, attendant);
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        assertThrows(ParkingLotFullException.class, () -> parkingLot.park(new Car()));
    }

    @Test
    void shouldReturnTrueIfACarIsUnparked() throws ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(3, attendant);
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        assertTrue(parkingLot.unpark());
    }

    @Test
    void shouldNotifyTheAttendentWhenParkingLotIsFull() throws ParkingLotFullException {
        mockedAttendant mockedAttendent = new mockedAttendant();
        ParkingLot parkingLot = new ParkingLot(3, mockedAttendent);
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        assertTrue(mockedAttendent.isNotifiedForFull);
    }

    @Test
    void shouldNotifyAttendantWhenParkingLotIsAvailable() throws ParkingLotFullException {
        mockedAttendant mockedattendant = new mockedAttendant();
        ParkingLot parkingLot = new ParkingLot(3, mockedattendant);
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        parkingLot.unpark();
        assertTrue(mockedattendant.isNotifiedForAvailable);
    }

    @Test
    void shouldReturnFalseIfParkingLotIsEmpty() {
        ParkingLot parkingLot = new ParkingLot(3, attendant);
        assertFalse(parkingLot.unpark());
    }
}

class mockedAttendant extends Attendant {
    boolean isNotifiedForFull;
    boolean isNotifiedForAvailable;

    @Override
    void notifyWhenFull(ParkingLot parkingLot) {
        this.isNotifiedForFull = true;
    }

    @Override
    void notifyWhenAvailable(ParkingLot parkingLot) {
        this.isNotifiedForAvailable = true;
    }
}