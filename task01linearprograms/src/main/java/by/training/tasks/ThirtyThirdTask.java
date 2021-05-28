package by.training.tasks;

public class ThirtyThirdTask {

    public ThirtyThirdTask() {
    }

    /**
     * Method for finding serial number of a symbol
     *
     * @param str Entered symbols by user
     * @return symbol serial number
     */
    public int getPositions(String str) {
        char symbol = str.charAt(0);
        return (int) symbol;
    }

    /**
     * finding the previous symbol based on the found serial number
     *
     * @param symbol serial number of entered symbol
     * @return previous symbol
     */
    public char getPreviousSymbol(int symbol) {
        return (char) --symbol;
    }

    /**
     * finding the next symbols based on the found serial number
     *
     * @param symbol serial number of entered symbol
     * @return previous symbol
     */
    public char getNextSymbol(int symbol) {
        return (char) ++symbol;
    }
}