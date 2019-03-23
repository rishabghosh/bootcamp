package matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class matrixTest {
    @Test
    void setColumnShouldSetTheRequiredRowAndReturnTheMatrix() {
        Matrix matrix = new Matrix(2, 2);
        Matrix actual = matrix.setColumn(0, new int[]{3, 4});
        int[][] ints = new int[][]{new int[]{3, 4}, new int[]{0, 0}};
        Matrix expected = new Matrix(ints);
        assertEquals(expected, actual);
    }

    @Test
    void switchRowsShouldSwitchTheGivenTwoRowNumbersAndReturnACopyOfCurrentMatrix() {
        int[][] ints = new int[][]{new int[]{3, 4}, new int[]{0, 0}};
        Matrix matrix = new Matrix(ints);

        int[][] ints2 = new int[][]{new int[]{0,0}, new int[]{3,4}};
        Matrix expected = new Matrix(ints2);

        Matrix actual = matrix.switchRows(0,1);
        assertEquals(expected, actual);
    }
}