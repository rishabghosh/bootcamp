package matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class matrixTest {

    @Test
    void switchRowsShouldSwitchTheGivenTwoRowNumbersAndReturnACopyOfCurrentMatrix() {
        int[][] ints = new int[][]{new int[]{3, 4}, new int[]{0, 0}};
        Matrix matrix = new Matrix(ints);

        int[][] ints2 = new int[][]{new int[]{0, 0}, new int[]{3, 4}};
        Matrix expected = new Matrix(ints2);

        Matrix actual = matrix.switchRows(0, 1);
        assertEquals(expected, actual);
    }

    @Test
    void addMethodShouldAddGivenMatrixWithCurrentMatrixFor2By2Matrix() throws IncompatibleMatricesException {
        int[][] ints = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
        int[][] ints2 = new int[][]{new int[]{5, 6}, new int[]{7, 8}};
        int[][] ints3 = new int[][]{new int[]{6, 8}, new int[]{10, 12}};

        Matrix matrix1 = new Matrix(ints);
        Matrix matrix2 = new Matrix(ints2);

        Matrix actual = matrix1.add(matrix2);
        Matrix expected = new Matrix(ints3);
        assertEquals(expected, actual);
    }

    @Test
    void addMethodShouldAddGivenMatrixWithCurrentMatrixFor3By3Matrix() throws IncompatibleMatricesException {
        int[][] ints = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}};
        int[][] ints2 = new int[][]{new int[]{7, 8, 9}, new int[]{9, 10, 11}};
        int[][] ints3 = new int[][]{new int[]{8, 10, 12}, new int[]{13, 15, 17}};

        Matrix matrix1 = new Matrix(ints);
        Matrix matrix2 = new Matrix(ints2);

        Matrix actual = matrix1.add(matrix2);
        Matrix expected = new Matrix(ints3);
        assertEquals(expected, actual);
    }

    @Test
    void addMethodShouldThrowExceptionWhenTwoIncompatibleMatricesAreAdded() {
        int[][] ints = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}};
        int[][] ints2 = new int[][]{new int[]{5, 6}, new int[]{7, 8}};

        Matrix matrix1 = new Matrix(ints);
        Matrix matrix2 = new Matrix(ints2);
        assertThrows(IncompatibleMatricesException.class, ()-> matrix1.add(matrix2));
    }
}