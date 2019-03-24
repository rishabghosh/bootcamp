package matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class matrixTest {

    @Test
    void createNullMatrixShouldThrowExceptionIfMIsLessThan1() throws InvalidDimensionException {
        assertThrows(InvalidDimensionException.class, () -> Matrix.createNullMatrix(0, 2));
    }

    @Test
    void createNullMatrixShouldThrowExceptionIfNIsLessThan1() throws InvalidDimensionException {
        assertThrows(InvalidDimensionException.class, () -> Matrix.createNullMatrix(2, 0));

    }

    @Test
    void createMethodShouldThrowExceptionIfSourceArrayNIsLessThan1() {
        assertThrows(InvalidDimensionException.class, ()-> Matrix.create(new int[1][0]));
    }

    @Test
    void switchRowsShouldSwitchTheGivenTwoRowNumbersAndReturnACopyOfCurrentMatrix() throws InvalidDimensionException {
        int[][] ints = new int[][]{new int[]{3, 4}, new int[]{0, 0}};
        Matrix matrix = Matrix.create(ints);

        int[][] ints2 = new int[][]{new int[]{0, 0}, new int[]{3, 4}};
        Matrix expected = Matrix.create(ints2);

        Matrix actual = matrix.swapRows(0, 1);
        assertEquals(expected, actual);
    }

    @Test
    void addMethodShouldAddGivenMatrixWithCurrentMatrixFor2By2Matrix() throws IncompatibleMatricesException, InvalidDimensionException {
        int[][] ints = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
        int[][] ints2 = new int[][]{new int[]{5, 6}, new int[]{7, 8}};
        int[][] ints3 = new int[][]{new int[]{6, 8}, new int[]{10, 12}};

        Matrix matrix1 = Matrix.create(ints);
        Matrix matrix2 = Matrix.create(ints2);

        Matrix actual = matrix1.add(matrix2);
        Matrix expected = Matrix.create(ints3);
        assertEquals(expected, actual);
    }

    @Test
    void addMethodShouldAddGivenMatrixWithCurrentMatrixFor3By3Matrix() throws IncompatibleMatricesException, InvalidDimensionException {
        int[][] ints = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}};
        int[][] ints2 = new int[][]{new int[]{7, 8, 9}, new int[]{9, 10, 11}};
        int[][] ints3 = new int[][]{new int[]{8, 10, 12}, new int[]{13, 15, 17}};

        Matrix matrix1 = Matrix.create(ints);
        Matrix matrix2 = Matrix.create(ints2);

        Matrix actual = matrix1.add(matrix2);
        Matrix expected = Matrix.create(ints3);
        assertEquals(expected, actual);
    }

    @Test
    void addMethodShouldThrowExceptionWhenTwoIncompatibleMatricesAreAdded() throws InvalidDimensionException {
        int[][] ints = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}};
        int[][] ints2 = new int[][]{new int[]{5, 6}, new int[]{7, 8}};

        Matrix matrix1 = Matrix.create(ints);
        Matrix matrix2 = Matrix.create(ints2);
        assertThrows(IncompatibleMatricesException.class, () -> matrix1.add(matrix2));
    }

    @Test
    void multiplyWithConstantMethodShouldMultiplyAllElementsOfMatrixWithTheConstant() throws InvalidDimensionException {
        int[][] ints = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}};
        int[][] ints2 = new int[][]{new int[]{2, 4, 6}, new int[]{8, 10, 12}};
        Matrix matrix = Matrix.create(ints);
        Matrix actual = matrix.multiplyWithConstant(2);
        Matrix expected = Matrix.create(ints2);
        assertEquals(expected, actual);
    }

    @Test
    void subtractMethodShouldSubtractGivenMatrixFromCurrentMatrixFor2By2Matrix() throws IncompatibleMatricesException, InvalidDimensionException {
        int[][] ints = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
        int[][] ints2 = new int[][]{new int[]{5, 6}, new int[]{7, 8}};
        int[][] ints3 = new int[][]{new int[]{4, 4}, new int[]{4, 4}};

        Matrix matrix1 = Matrix.create(ints);
        Matrix matrix2 = Matrix.create(ints2);

        Matrix actual = matrix2.subtract(matrix1);
        Matrix expected = Matrix.create(ints3);
        assertEquals(expected, actual);
    }
}