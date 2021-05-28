package by.training.tasks;

public class SeventeenthTask {

    public SeventeenthTask() {
    }

    /**
     * Method calculate geometric mean of variables a and b
     *
     * @return geometric mean of a and b
     */
    public double geometricMean(double a, double b) {
        return  Math.sqrt(Math.abs(a) * Math.abs(b));
    }

    /**
     * Method calculate average of variables a^3 and b^3
     *
     * @return average of a^3 and b^3
     */
    public double average(double a, double b) {
        return (Math.pow(a, 3) + Math.pow(b, 3)) / 2;
    }
}
