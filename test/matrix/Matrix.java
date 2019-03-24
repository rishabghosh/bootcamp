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

    Matrix(int[][] data) {
        this.numberOfRows = data.length;
        this.numberOfColumns = data[0].length;

        this.matrix = new int[this.numberOfRows][this.numberOfColumns];
        for (int index = 0; index < this.numberOfRows; index++) {
            System.arraycopy(data[index], 0, this.matrix[index], 0, this.numberOfColumns);
        }
    }

    Matrix switchRows(int row1, int row2) {
        int[] temp = this.matrix[row1];
        this.matrix[row1] = this.matrix[row2];
        this.matrix[row2] = temp;
        return new Matrix(this.matrix);
    }


    public Matrix add(Matrix matrix) throws IncompatibleMatricesException {
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


}
