package matrix;

import java.util.Arrays;

public class Matrix {
    private final int[][] matrix;
    private int numberOfRows;
    private int numberOfColumns;

    Matrix(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.matrix = new int[numberOfRows][numberOfColumns];
    }

    Matrix(int[][] ints) {
        this.numberOfRows = ints.length;
        this.numberOfColumns = ints[0].length;

        this.matrix = new int[this.numberOfRows][this.numberOfColumns];
        for (int index = 0; index < this.numberOfRows; index++) {
            System.arraycopy(ints[index], 0, this.matrix[index], 0, this.numberOfColumns);
        }
    }

    Matrix switchRows(int row1, int row2) {
        int[] temp = this.matrix[row1];
        this.matrix[row1] = this.matrix[row2];
        this.matrix[row2] = temp;
        return new Matrix(this.matrix);
    }


    Matrix add(Matrix matrix) throws IncompatibleMatricesException {
        int numberOfRows = matrix.numberOfRows;
        int numberOfColumns = matrix.numberOfColumns;

        if(doesNotHaveSameStructure(numberOfRows, numberOfColumns)) {
            throw new IncompatibleMatricesException();
        }

        for (int rowIndex = 0; rowIndex < matrix.numberOfRows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix.numberOfColumns; columnIndex++) {
                this.matrix[rowIndex][columnIndex] += matrix.matrix[rowIndex][columnIndex];
            }
        }
        return new Matrix(this.matrix);
    }

    private boolean doesNotHaveSameStructure(int numberOfRows, int numberOfColumns){
        return this.numberOfRows != numberOfRows || this.numberOfColumns != numberOfColumns;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Matrix)) return false;
        Matrix matrix1 = (Matrix) obj;
        return Arrays.deepEquals(this.matrix, matrix1.matrix);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.matrix);
    }

    Matrix multiplyWithConstant(int constant) {
        for (int rowIndex = 0; rowIndex < this.numberOfRows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < this.numberOfColumns; columnIndex++) {
                this.matrix[rowIndex][columnIndex] *= constant;
            }
        }
        return new Matrix(this.matrix);
    }

    private Matrix multiplyMatrixWithConstant(Matrix matrix, int constant) {
        Matrix newMatrix = new Matrix(matrix.numberOfRows, matrix.numberOfColumns);
        for (int index = 0; index < matrix.numberOfRows; index++) {
            System.arraycopy(matrix.matrix[index], 0, newMatrix.matrix[index], 0, matrix.numberOfColumns);
        }

        for (int rowIndex = 0; rowIndex < matrix.numberOfRows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix.numberOfColumns; columnIndex++) {
                newMatrix.matrix[rowIndex][columnIndex] *= constant;
            }
        }
        return newMatrix;
    }



    Matrix subtract(Matrix matrix) throws IncompatibleMatricesException {
        Matrix modifiedMatrix = this.multiplyMatrixWithConstant(matrix, -1);
        return this.add(modifiedMatrix);
    }
}
