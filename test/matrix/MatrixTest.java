package matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatrixTest {

    private int[][] twoByTwoArray;
    private int[][] threeByThreeArray;
    private int[][] twoByThreeArray;
    private int[][] threeByTwoArray;

    @BeforeEach
    void setUp() {
        twoByTwoArray = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
        threeByThreeArray = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
        twoByThreeArray = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}};
        threeByTwoArray = new int[][]{new int[]{1, 2}, new int[]{3, 4}, new int[]{5, 6}};
    }

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
        assertThrows(InvalidDimensionException.class, () -> Matrix.create(new int[1][0]));
    }


    @Test
    void switchRowsShouldSwitchTheGivenTwoRowNumbersAndReturnACopyOfCurrentMatrix() throws InvalidDimensionException {
        int[][] flippedArray = new int[][]{new int[]{3,4}, new int[]{1,2}};
        Matrix matrix = Matrix.create(twoByTwoArray);
        Matrix expected = Matrix.create(flippedArray);
        Matrix actual = matrix.swapRows(0, 1);
        assertEquals(expected, actual);
    }

    @Test
    void addMethodShouldAddGivenMatrixWithCurrentMatrixFor2By2Matrix() throws IncompatibleMatricesException, InvalidDimensionException {
        int[][] anotherTwoByTwoArray = new int[][]{new int[]{5, 6}, new int[]{7, 8}};
        int[][] resultant = new int[][]{new int[]{6, 8}, new int[]{10, 12}};

        Matrix matrix1 = Matrix.create(twoByTwoArray);
        Matrix matrix2 = Matrix.create(anotherTwoByTwoArray);

        Matrix actual = matrix1.add(matrix2);
        Matrix expected = Matrix.create(resultant);
        assertEquals(expected, actual);
    }

    @Test
    void addMethodShouldAddGivenMatrixWithCurrentMatrixFor3By3Matrix() throws IncompatibleMatricesException, InvalidDimensionException {
        int[][] anotherThreeByTwoArray = new int[][]{new int[]{7, 8, 9}, new int[]{9, 10, 11}};
        int[][] resultant = new int[][]{new int[]{8, 10, 12}, new int[]{13, 15, 17}};

        Matrix matrix1 = Matrix.create(twoByThreeArray);
        Matrix matrix2 = Matrix.create(anotherThreeByTwoArray);

        Matrix actual = matrix1.add(matrix2);
        Matrix expected = Matrix.create(resultant);
        assertEquals(expected, actual);
    }

    @Test
    void addMethodShouldThrowExceptionWhenTwoIncompatibleMatricesAreAdded() throws InvalidDimensionException {
        Matrix matrix1 = Matrix.create(twoByThreeArray);
        Matrix matrix2 = Matrix.create(twoByTwoArray);
        assertThrows(IncompatibleMatricesException.class, () -> matrix1.add(matrix2));
    }

    @Test
    void multiplyWithConstantMethodShouldMultiplyAllElementsOfMatrixWithTheConstant() throws InvalidDimensionException {
        int[][] resultant = new int[][]{new int[]{2, 4, 6}, new int[]{8, 10, 12}};
        Matrix matrix = Matrix.create(twoByThreeArray);
        Matrix actual = matrix.multiplyByConstant(2);
        Matrix expected = Matrix.create(resultant);
        assertEquals(expected, actual);
    }

    @Test
    void subtractMethodShouldSubtractGivenMatrixFromCurrentMatrixFor2By2Matrix() throws IncompatibleMatricesException, InvalidDimensionException {
        int[][] anotherTwoByTwoMatrix = new int[][]{new int[]{5, 6}, new int[]{7, 8}};
        int[][] resultant = new int[][]{new int[]{4, 4}, new int[]{4, 4}};

        Matrix matrix1 = Matrix.create(twoByTwoArray);
        Matrix matrix2 = Matrix.create(anotherTwoByTwoMatrix);

        Matrix actual = matrix2.subtract(matrix1);
        Matrix expected = Matrix.create(resultant);
        assertEquals(expected, actual);
    }

    @Test
    void multiplyMethodShouldMultiplyCurrentMatrixWithGivenMatrix() throws InvalidDimensionException {
        int[][] anotherTwoByTwoArray = new int[][]{new int[]{5, 6}, new int[]{7, 8}};
        int[][] resultant = {new int[]{19, 22}, new int[]{43, 50}};

        Matrix matrix1 = Matrix.create(twoByTwoArray);
        Matrix matrix2 = Matrix.create(anotherTwoByTwoArray);

        Matrix actual = matrix1.multiply(matrix2);
        Matrix expected = Matrix.create(resultant);
        assertEquals(expected, actual);
    }

    @Test
    void multiplyMethodShouldMultiplyCurrentMatrixWithGivenMatrix3By3() throws InvalidDimensionException {
        int[][] anotherThreeByTwoArray = new int[][]{new int[]{7, 8}, new int[]{9, 10}, new int[]{11, 12}};
        int[][] resultant = {new int[]{58, 64}, new int[]{139, 154}};

        Matrix matrix1 = Matrix.create(twoByThreeArray);
        Matrix matrix2 = Matrix.create(anotherThreeByTwoArray);

        Matrix actual = matrix1.multiply(matrix2);
        Matrix expected = Matrix.create(resultant);
        assertEquals(expected, actual);
    }
}