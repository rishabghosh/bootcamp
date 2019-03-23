package matrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
}