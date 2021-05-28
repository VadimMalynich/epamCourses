package by.training.tasks.branches;

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
        if (a > b) {
            return a;
        } else {
            return b;
        }
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
        if (a == b && a == c) {
            return true;
        } else {
            return false;
        }
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
            if (m > n) {
                return m;
            } else {
                return n;
            }
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
        if (temperature < -273.15) {
            throw new IllegalArgumentException("Impossible value for temperature!");
        }
        if (temperature > 60) {
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
        if (password < 1000 || password >= 10000) {
            throw new IllegalArgumentException("Password must be 4 characters!");
        }
        if (password == 9583 || password == 1747) {
            return "Your access level allows you to interact with database modules A, B and C!";
        } else if (password == 3331 || password == 7922) {
            return "Your access level allows you to interact with database modules B and C!";
        } else if (password == 9455 || password == 8997) {
            return "Your access level allows you to interact with database module C!";
        } else {
            return "Your access level not allows you to interact with database modules!";
        }
    }
}
