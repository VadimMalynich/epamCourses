package by.training.tasks;

/**
 * Class for finding the value of an expression using a formula:
 * a / c * b / d - ( a * b - c ) / c / d
 */
public class NinthTask {
    public NinthTask() {
    }

    /**
     * Method that evaluates the value of an expression
     *
     * @param a double value one of the variables
     * @param b double value one of the variables
     * @param c double value one of the variables
     * @param d double value one of the variables
     * @return calculation result of expression
     */
    public double calcResult(double a, double b, double c, double d) {
        if (c == 0 || d == 0) {
            throw new IllegalArgumentException("One of the variables in the denominator is 0");
        }
        return a / c * b / d - (a * b - c) / (c * d);
    }
}
