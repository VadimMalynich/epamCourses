package by.training.task02.tasks.branches;

/**
 * Class for solving branching problems
 */
public class BranchesTasks {

    /**
     * Method compare two values
     *
     * @param a first value
     * @param b second value
     * @return greater importance
     */
    public int comparison(int a, int b) {
        if (a == b) {
            throw new IllegalArgumentException("Variables are equal!");
        }
        return a > b ? a : b;
    }

    /**
     * The method checks the triangle for equilateral
     *
     * @param a first side
     * @param b second side
     * @param c third side
     * @return boolean answer
     */
    public boolean isEquilateralTriangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("One or more side has wrong value");
        }
        return (a == b && a == c);
    }

    /**
     * Method checks two parameters for equality
     *
     * @param m first value
     * @param n second value
     * @return bigger value if not equal or zero if equal
     */
    public int checkNumbersEquals(int m, int n) {
        if (m != n) {
            return m > n ? m : n;
        } else {
            return 0;
        }
    }

    /**
     * Check temperature for normal
     *
     * @param temperature float value
     * @return String message
     */
    public String checkTemperatureForNormal(double temperature) {
        final double CRITICAL_TEMPERATURE = -273.15;
        if (temperature < CRITICAL_TEMPERATURE) {
            throw new IllegalArgumentException("Impossible value for temperature!");
        }
        final double FIRE_TEMPERATURE = 60;
        if (temperature > FIRE_TEMPERATURE) {
            return "Fire hazardous situation.";
        } else {
            return "Temperature is normal.";
        }
    }

    /**
     * Method check password to provide level access
     *
     * @param password four-digit number
     * @return message with access level
     */
    public String checkPassword(int password) {
        final int MIN_PASSWORD_VALUE = 1000;
        final int MAX_PASSWORD_VALUE = 10000;
        if (password < MIN_PASSWORD_VALUE || password >= MAX_PASSWORD_VALUE) {
            throw new IllegalArgumentException("Password must be 4 characters!");
        }
        final int FIRST_PASSWORD_FOR_ACCESS_A_B_C_LEVEL = 9583;
        final int SECOND_PASSWORD_FOR_ACCESS_A_B_C_LEVEL = 1747;
        final int FIRST_PASSWORD_FOR_ACCESS_B_C_LEVEL = 3331;
        final int SECOND_PASSWORD_FOR_ACCESS_B_C_LEVEL = 7922;
        final int FIRST_PASSWORD_FOR_ACCESS_C_LEVEL = 9455;
        final int SECOND_PASSWORD_FOR_ACCESS_C_LEVEL = 8997;
        if (password == FIRST_PASSWORD_FOR_ACCESS_A_B_C_LEVEL || password == SECOND_PASSWORD_FOR_ACCESS_A_B_C_LEVEL) {
            return "Your access level allows you to interact with database modules A, B and C!";
        } else if (password == FIRST_PASSWORD_FOR_ACCESS_B_C_LEVEL || password == SECOND_PASSWORD_FOR_ACCESS_B_C_LEVEL) {
            return "Your access level allows you to interact with database modules B and C!";
        } else if (password == FIRST_PASSWORD_FOR_ACCESS_C_LEVEL || password == SECOND_PASSWORD_FOR_ACCESS_C_LEVEL) {
            return "Your access level allows you to interact with database module C!";
        } else {
            return "Your access level not allows you to interact with database modules!";
        }
    }
}
