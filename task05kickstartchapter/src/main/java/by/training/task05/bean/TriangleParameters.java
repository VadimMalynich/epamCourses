package by.training.task05.bean;

public class TriangleParameters {
    private double perimeter;
    private double square;

    public TriangleParameters(double perimeter, double square) {
        this.perimeter = perimeter;
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getSquare() {
        return square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TriangleParameters that = (TriangleParameters) o;
        return Double.compare(that.perimeter, perimeter) == 0 && Double.compare(that.square, square) == 0;
    }

    @Override
    public int hashCode() {
        return (int) (perimeter + 31 * square);
    }

    @Override
    public String toString() {
        return "TriangleParameters{" +
                "perimeter=" + perimeter +
                ", square=" + square +
                '}';
    }
}
