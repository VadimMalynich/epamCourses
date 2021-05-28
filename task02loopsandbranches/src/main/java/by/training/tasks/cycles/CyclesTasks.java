package by.training.tasks.cycles;

public class CyclesTasks {
    /**
     * Method write numbers from a to b in string
     *
     * @param a start value
     * @param b finish value
     * @return string with numbers
     */
    public String getNumbersString(int a, int b) {
        if (a > b) {
            throw new IllegalArgumentException("Wrong interval from " + a + " to " + b + "!");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = a; i <= b; i++) {
            stringBuilder.append(i + "; ");
        }
        stringBuilder.delete(stringBuilder.lastIndexOf(";"), stringBuilder.length());
        stringBuilder.insert(stringBuilder.length(), ".");
        return stringBuilder.toString();
    }

    /**
     * Method calculated sum of squares from 0 to n
     *
     * @param n finish value
     * @return calculated sum of squares
     */
    public long calcSumOfSquares(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("For calculate sum of squares number should be > 0!");
        }
        long sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += Math.pow(i, 2);
        }
        return sum;
    }


    /**
     * Search method for the result of an expression of the form: a(a+1)...(a+n-1)
     *
     * @param a value
     * @param n finish value
     * @return decision
     */
    public long solveExpression(int a, int n) {
        if (n == 0) {
            throw new IllegalArgumentException("Invalid value for solve expression!");
        }
        long result = 1;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                result *= (a + i);
            }
        } else {
            for (int i = 0; i > n; i--) {
                result *= (a + i);
            }
        }
        return result;
    }

    /**
     * Method calculate factorial of value that entered user
     *
     * @param n user value
     * @return factorial
     */
    public long calcFactorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("Invalid value for calculate factorial!");
        }
        long factorial = 1;
        if (n == 0) {
            return 1;
        } else {
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
        }
        return factorial;
    }

    /**
     * Method find the biggest digit in number
     *
     * @param n long number
     * @return max digit
     */
    public int findBiggestDigit(long n) {
        if (n <= 0) {
            throw new IllegalArgumentException("It's not natural number!");
        }
        int digit = 0;
        int a;
        while (n > 0) {
            a = Math.toIntExact(n % 10);
            if (a > digit) {
                digit = a;
            }
            n = n / 10;
        }
        return digit;
    }
}