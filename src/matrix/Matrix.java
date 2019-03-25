package matrix;

import java.util.Arrays;

public class Matrix {
    private int[][] body;
    private int M;  //number of rows
    private int N;  //number of columns

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


    /* =========== Overrides ============= */


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


    /* ============== Statics ============== */


    static Matrix createNullMatrix(int M, int N) throws InvalidDimensionException {
        if (M < 1 || N < 1) throw new InvalidDimensionException();
        return new Matrix(M, N);
    }

    static Matrix create(int[][] sourceArray) throws InvalidDimensionException {
        int N = sourceArray[0].length;
        if (N < 1) throw new InvalidDimensionException();
        return new Matrix(sourceArray);
    }


    /* ============= Privates =============== */


    private int[][] buildMatrix(int[][] sourceArray) {
        int[][] matrixBody = new int[this.M][this.N];
        for (int rowIndex = 0; rowIndex < this.M; rowIndex++) {
            System.arraycopy(sourceArray[rowIndex], 0, matrixBody[rowIndex], 0, this.N);
        }
        return matrixBody;
    }

    private boolean isIncompatible(int rowSize, int columnSize) {
        return this.M != rowSize || this.N != columnSize;
    }

    private Matrix clone(Matrix matrix) {
        int[][] body = buildMatrix(matrix.body);
        return new Matrix(body);
    }

    private Matrix multiplyByConstant(Matrix matrix, int constant) {
        Matrix newMatrix = this.clone(matrix);
        for (int rowIndex = 0; rowIndex < matrix.M; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix.N; columnIndex++) {
                newMatrix.body[rowIndex][columnIndex] *= constant;
            }
        }
        return newMatrix;
    }


    /* ============= Main Methods ============= */


    Matrix swapRows(int row1, int row2) {
        int[] temp = this.body[row1];
        this.body[row1] = this.body[row2];
        this.body[row2] = temp;
        return new Matrix(this.body);
    }

    Matrix add(Matrix matrix) throws IncompatibleMatricesException {
        if (isIncompatible(matrix.M, matrix.N)) throw new IncompatibleMatricesException();

        for (int rowIndex = 0; rowIndex < matrix.M; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix.N; columnIndex++) {
                this.body[rowIndex][columnIndex] += matrix.body[rowIndex][columnIndex];
            }
        }
        return new Matrix(this.body);
    }

    Matrix multiplyByConstant(int constant) {
        for (int rowIndex = 0; rowIndex < this.M; rowIndex++) {
            for (int columnIndex = 0; columnIndex < this.N; columnIndex++) {
                this.body[rowIndex][columnIndex] *= constant;
            }
        }
        return new Matrix(this.body);
    }



    Matrix subtract(Matrix matrix) throws IncompatibleMatricesException {
        Matrix modifiedMatrix = this.multiplyByConstant(matrix, -1);
        return this.add(modifiedMatrix);
    }

    Matrix multiply(Matrix matrix) {
        Matrix resultMatrix = new Matrix(new int[this.M][this.M]);

        int commonRowIndex = 0;
        while (commonRowIndex < this.M) {
            int columnOfResultant = 0;

            while (columnOfResultant < resultMatrix.M) {
                int activeIndex = 0;

                while (activeIndex < this.N) {
                    resultMatrix.body[commonRowIndex][columnOfResultant] +=
                            this.body[commonRowIndex][activeIndex] * matrix.body[activeIndex][columnOfResultant];
                    activeIndex++;
                }
                columnOfResultant++;
            }
            commonRowIndex++;
        }

        this.body = resultMatrix.body;
        return resultMatrix;
    }


}
