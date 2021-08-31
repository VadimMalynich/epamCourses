package by.training.multithreading.bean;

import java.util.Objects;

public class MatrixValues {
    private int value;
    private int changeCounter;

    public MatrixValues(int value) {
        this.value = value;
        this.changeCounter = 0;
    }

    public void changeValue(int value) {
        this.value = value;
        changeCounter++;
    }

    public int getValue() {
        return value;
    }

    public int getChangeCounter() {
        return changeCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatrixValues that = (MatrixValues) o;
        return value == that.value && changeCounter == that.changeCounter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, changeCounter);
    }

    @Override
    public String toString() {
        return "MatrixValues{" +
                "value=" + value +
                ", changeCounter=" + changeCounter +
                '}';
    }
}
