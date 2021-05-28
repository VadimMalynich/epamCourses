package by.training.tasks;

public class TwentyFifthTask {
    public TwentyFifthTask() {
    }

    /**
     * Method calculates the discriminant
     *
     * @param a double value
     * @param b double value
     * @param c double value
     * @return discriminant
     */
    public double calcDiscriminant(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("Argument a = 0");
        }
        return Math.pow(b, 2) - 4 * a * c;
    }

    /**
     * Calculate roots if discriminant = 0
     *
     * @param a double value
     * @param b double value
     * @return two identical roots
     */
    public double calcTwoRoots(double a, double b) {
        return -b / 2 / a;
    }

    /**
     * Calculate first root if discriminant > 0
     *
     * @param a            double value
     * @param b            double value
     * @param discriminant
     * @return first root
     */
    public double calcFirstRoot(double a, double b, double discriminant) {
        return (-b + Math.sqrt(discriminant)) / 2 / a;
    }

    /**
     * Calculate second root if discriminant > 0
     *
     * @param a            double value
     * @param b            double value
     * @param discriminant double value
     * @return second root
     */
    public double calcSecondRoot(double a, double b, double discriminant) {
        return (-b - Math.sqrt(discriminant)) / 2 / a;
    }
}
