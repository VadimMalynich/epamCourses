package by.training.informationhandling.bean;

import java.util.ArrayList;

public class Composite implements Component {
    private Type type;
    private ArrayList<Component> components = new ArrayList<>();

    public Composite(Type type) {
        this.type = type;
    }

    public void add(Component c) {
        components.add(c);
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public int getComponentsCount() {
        return components.size();
    }

    @Override
    public String collect() {
        StringBuilder builder = new StringBuilder();
        for (Component component : components) {
            builder.append(component.collect());
            switch (type) {
                case PARAGRAPH -> builder.deleteCharAt(builder.length() - 1).append(System.lineSeparator()).append("\t");
                case LEXEME -> builder.append(" ");
                case TEXT -> {
                    int index = builder.lastIndexOf(System.lineSeparator());
                    builder.insert(0, "\t").delete(index + 1, builder.length());
                }
            }
        }
        return builder.toString();
    }
}
