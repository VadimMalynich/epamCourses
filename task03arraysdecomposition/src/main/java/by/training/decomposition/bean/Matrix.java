package by.training.decomposition.bean;

import java.util.Arrays;

public class Matrix {
    private double[][] a;

    public Matrix(double[][] a) {
        this.a = a;
    }

    public Matrix(int n, int m) {
        a = new double[n][m];
    }

    public int getVerticalSize() {
        return a.length;
    }

    public int getHorizontalSize() {
        return a[0].length;
    }

    public double getElement(int i, int j) {
        return a[i][j];
    }

    public void setElement(int i, int j, double value) {
        a[i][j] = value;
    }

    @Override
    public String toString() {
        final String BLANK = " ";
        StringBuilder s = new StringBuilder("\nMatrix : " + a.length + "x"
                + a[0].length + "\n");
        for (double[] row : a) {
            for (double value : row) {
                s.append(value).append(BLANK);
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
        int v = matrix.getVerticalSize();
        int h = matrix.getHorizontalSize();
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
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

    private boolean checkRange(int i, int j) {
        return (i >= 0 && i < a.length && j >= 0 && j < a[0].length);
    }
}
