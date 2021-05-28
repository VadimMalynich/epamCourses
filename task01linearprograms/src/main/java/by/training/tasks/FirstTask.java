package by.training.tasks;

//Class intended to find sum, difference, product and quotient between x and y
public class FirstTask {

    public FirstTask() {
    }

    /**
     * Method calculates the amount between x and y
     *
     * @return sum between x and y
     */
    public double sum(double x, double y) {
        return x + y;
    }

    /**
     * Method calculates the difference between x and y
     *
     * @return difference
     */
    public double difference(double x, double y) {
        return x - y;
    }

    /**
     * Method calculates the product between x and y
     *
     * @return product
     */
    public double product(double x, double y) {
        return x * y;
    }

    /**
     * Method calculates the quotient between x and y
     *
     * @return quotient
     */
    public double quotient(double x, double y) {
        if (y == 0) {
            throw new IllegalArgumentException("Division by 0");
        }
        return x / y;
    }
}
