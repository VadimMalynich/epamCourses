package by.training.task05.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Triangle {
    private long id;
    private String name;
    private double firstSideLength;
    private double secondSideLength;
    private double thirdSideLength;
    private List<Point> points = new ArrayList<>();

    public Triangle(String name) {
        this.name = name;
    }

    public Triangle(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Triangle(double firstSideLength, double secondSideLength, double thirdSideLength) {
        this.firstSideLength = firstSideLength;
        this.secondSideLength = secondSideLength;
        this.thirdSideLength = thirdSideLength;
    }

    public Triangle(long id, String name, double firstSideLength, double secondSideLength, double thirdSideLength, List<Point> points) {
        this.id = id;
        this.name = name;
        this.firstSideLength = firstSideLength;
        this.secondSideLength = secondSideLength;
        this.thirdSideLength = thirdSideLength;
        this.points = points;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFirstSideLength() {
        return firstSideLength;
    }

    public void setFirstSideLength(double firstSideLength) {
        this.firstSideLength = firstSideLength;
    }

    public double getSecondSideLength() {
        return secondSideLength;
    }

    public void setSecondSideLength(double secondSideLength) {
        this.secondSideLength = secondSideLength;
    }

    public double getThirdSideLength() {
        return thirdSideLength;
    }

    public void setThirdSideLength(double thirdSideLength) {
        this.thirdSideLength = thirdSideLength;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public void setPoint(Point oldPoint, Point newPoint) {
        points.remove(oldPoint);
        points.add(newPoint);
    }

    public class Point {
        private double x;
        private double y;
//        private double secondX;
//        private double secondY;
//        private double thirdX;
//        private double thirdY;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
//        public Point(double firstX, double firstY, double secondX, double secondY, double thirdX, double thirdY) {
//            this.firstX = firstX;
//            this.firstY = firstY;
//            this.secondX = secondX;
//            this.secondY = secondY;
//            this.thirdX = thirdX;
//            this.thirdY = thirdY;
//        }

//        public double getFirstSide() {
//            return firstSideLength;
//        }
//
//        public double getSecondSide() {
//            return secondSideLength;
//        }
//
//        public double getThirdSide() {
//            return thirdSideLength;
//        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
        }

        @Override
        public int hashCode() {
            return (int) (x + 31 * y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return id == triangle.id && Double.compare(triangle.firstSideLength, firstSideLength) == 0
                && Double.compare(triangle.secondSideLength, secondSideLength) == 0
                && Double.compare(triangle.thirdSideLength, thirdSideLength) == 0 && Objects.equals(name, triangle.name)
                && Objects.equals(points, triangle.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, firstSideLength, secondSideLength, thirdSideLength, points);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstSideLength=" + firstSideLength +
                ", secondSideLength=" + secondSideLength +
                ", thirdSideLength=" + thirdSideLength +
                ", points=" + points +
                '}';
    }
}
