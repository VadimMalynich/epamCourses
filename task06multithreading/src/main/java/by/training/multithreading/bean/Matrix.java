package by.training.multithreading.bean;


import java.util.Arrays;

public class Matrix {
    private static Matrix instance;

    private MatrixValues[][] a;

    private Matrix(int n) {
        a = new MatrixValues[n][n];
    }

    public static Matrix getInstance() {
        return instance;
    }

    public static Matrix getInstance(int size) {
        if (instance == null) {
            instance = new Matrix(size);
        }
        return instance;
    }

    public int getSize() {
        return a.length;
    }

    public MatrixValues getElement(int i, int j) {
        return a[i][j];
    }

    public void setElement(int i, int j, int value) {
        a[i][j] = new MatrixValues(value);
    }

    public void changeDiagonalElement(int i, int value) {
        a[i][i].changeValue(value);
    }

    @Override
    public String toString() {
        final String BLANK = " ";
        StringBuilder s = new StringBuilder("Matrix : " + a.length + "x"
                + a[0].length + "\n");
        for (MatrixValues[] row : a) {
            for (MatrixValues value : row) {
                s.append(String.format("%4d", value.getValue())).append(BLANK);
            }
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        int n = matrix.getSize();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix.getElement(i, j) != a[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(a);
    }
}
