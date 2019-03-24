package matrix;

import java.util.Arrays;

public class Matrix {
    private final int[][] body;
    private int M;  //number of rows
    private int N;  //number of column


    private Matrix(int M, int N) {
        this.M = M;
        this.N = N;
        this.body = new int[M][N];
    }


    private Matrix(int[][] sourceArray) {
        this.M = sourceArray.length;
        this.N = sourceArray[0].length;
        this.body = buildMatrix(sourceArray);
    }


    static Matrix createNullMatrix(int M, int N) throws InvalidDimensionException {
        if (M <1 || N <1) throw new InvalidDimensionException();
        return new Matrix(M, N);
    }

    static Matrix create(int[][] sourceArray) throws InvalidDimensionException {
        int M = sourceArray.length;
        int N = sourceArray[0].length;
        if(N < 1) throw new InvalidDimensionException();
        return new Matrix(sourceArray);
    }

    private int[][] buildMatrix(int[][] sourceArray){
        int[][] matrixBody = new int[this.M][this.N];
        for (int rowIndex = 0; rowIndex < this.M; rowIndex++) {
            System.arraycopy(sourceArray[rowIndex], 0, matrixBody[rowIndex], 0, this.N);
        }
        return matrixBody;
    }

    Matrix swapRows(int row1, int row2) {
        int[] temp = this.body[row1];
        this.body[row1] = this.body[row2];
        this.body[row2] = temp;
        return new Matrix(this.body);
    }


    Matrix add(Matrix matrix) throws IncompatibleMatricesException {
        int numberOfRows = matrix.M;
        int numberOfColumns = matrix.N;

        if(doesNotHaveSameStructure(numberOfRows, numberOfColumns)) {
            throw new IncompatibleMatricesException();
        }

        for (int rowIndex = 0; rowIndex < matrix.M; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix.N; columnIndex++) {
                this.body[rowIndex][columnIndex] += matrix.body[rowIndex][columnIndex];
            }
        }
        return new Matrix(this.body);
    }

    private boolean doesNotHaveSameStructure(int numberOfRows, int numberOfColumns){
        return this.M != numberOfRows || this.N != numberOfColumns;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Matrix)) return false;
        Matrix matrix1 = (Matrix) obj;
        return Arrays.deepEquals(this.body, matrix1.body);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.body);
    }

    Matrix multiplyWithConstant(int constant) {
        for (int rowIndex = 0; rowIndex < this.M; rowIndex++) {
            for (int columnIndex = 0; columnIndex < this.N; columnIndex++) {
                this.body[rowIndex][columnIndex] *= constant;
            }
        }
        return new Matrix(this.body);
    }

    private Matrix multiplyMatrixWithConstant(Matrix matrix, int constant) {
        Matrix newMatrix = new Matrix(matrix.M, matrix.N);
        for (int index = 0; index < matrix.M; index++) {
            System.arraycopy(matrix.body[index], 0, newMatrix.body[index], 0, matrix.N);
        }

        for (int rowIndex = 0; rowIndex < matrix.M; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix.N; columnIndex++) {
                newMatrix.body[rowIndex][columnIndex] *= constant;
            }
        }
        return newMatrix;
    }



    Matrix subtract(Matrix matrix) throws IncompatibleMatricesException {
        Matrix modifiedMatrix = this.multiplyMatrixWithConstant(matrix, -1);
        return this.add(modifiedMatrix);
    }
}
