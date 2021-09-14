package by.training.informationhandling.bean;

public class Symbol implements Component{
    private static final Type TYPE = Type.SYMBOL;
    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String collect() {
        return String.valueOf(symbol);
    }
}
