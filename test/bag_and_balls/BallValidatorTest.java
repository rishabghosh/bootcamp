package bag_and_balls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BallValidatorTest {
    private BallValidator validator;
    @BeforeEach
    void setUp() {
        validator = new BallValidator();
    }

    @Test
    void isValidBallToAddMethodShouldReturnTrueIfNoOfBallsAreLessThan12() {
        ArrayList<Ball> balls = new ArrayList<>(Arrays.asList(Ball.BLUE, Ball.GREEN));
        assertTrue(validator.canBeAdded(Ball.RED, balls));
    }

    @Test
    void isValidBallToAddMethodShouldReturnFalseIfNoOfBallsAreEqualTo12() {
        ArrayList<Ball> balls = new ArrayList<>(Arrays.asList(Ball.BLUE, Ball.GREEN,Ball.BLUE, Ball.GREEN,Ball.BLUE, Ball.GREEN,Ball.BLUE, Ball.GREEN,Ball.BLUE, Ball.GREEN,Ball.BLUE, Ball.GREEN));
        assertFalse(validator.canBeAdded(Ball.RED, balls));
    }

    @Test
    void isValidBallToAddMethodShouldReturnFalseIfNoOfBallsAreMore12() {
        ArrayList<Ball> balls = new ArrayList<>(Arrays.asList(Ball.BLUE, Ball.GREEN,Ball.BLUE, Ball.GREEN,Ball.BLUE, Ball.GREEN,Ball.BLUE, Ball.GREEN,Ball.BLUE, Ball.GREEN,Ball.BLUE, Ball.GREEN, Ball.GREEN));
        assertFalse(validator.canBeAdded(Ball.RED, balls));
    }

    @Test
    void shouldReturnFalseWhenGreenBallsAreEqualToOrMoreThanThree() {
        ArrayList<Ball> balls = new ArrayList<>(Arrays.asList(Ball.GREEN, Ball.GREEN, Ball.GREEN));
        assertFalse(validator.canBeAdded(Ball.GREEN,balls));
    }
}