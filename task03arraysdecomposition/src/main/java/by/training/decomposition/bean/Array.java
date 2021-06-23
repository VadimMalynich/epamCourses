package by.training.decomposition.bean;

import java.util.Arrays;

public class Array {

    private double[] values;

    public Array(double[] values) {
        this.values = values;
    }

    public Array(int size) {
        values = new double[size];
    }

    public double getValue(int index) {
        return values[index];
    }

    public void setValue(double value, int index) {
        values[index] = value;
    }

    public int getLength() {
        return values.length;
    }

    public void swap(int a, int b) {
        double tmp = values[a];
        values[a] = values[b];
        values[b] = tmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array = (Array) o;
        int length = array.getLength();
        for (int i = 0; i < length; i++) {
            if (array.getValue(i) != values[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public String toString() {
        return "Array{" +
                "values=" + Arrays.toString(values) +
                '}';
    }
}
