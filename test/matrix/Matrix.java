package matrix;

import java.util.Arrays;

public class Matrix {
    private final int[][] matrix;
    private int numberOfRows;
    private int numberOfColumns;

    public Matrix(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.matrix = new int[numberOfRows][numberOfColumns];
    }

    public Matrix(int[][] data) {
        this.numberOfRows = data.length;
        this.numberOfColumns = data[0].length;

        this.matrix = new int[this.numberOfRows][this.numberOfColumns];
        for (int index = 0; index < this.numberOfRows; index++) {
            System.arraycopy(data[index], 0, this.matrix[index], 0, this.numberOfColumns);
        }
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

    public Matrix setColumn(int rowNumber, int[] column) {
        this.matrix[rowNumber] = column;
        return new Matrix(this.matrix);
    }
}
