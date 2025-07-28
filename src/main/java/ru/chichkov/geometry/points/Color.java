package ru.chichkov.geometry.points;

public class Color extends Attribute {
    public Color(String value) {
        super("color", value);
    }

    @Override
    public String getValue() {
        return super.getValue().toString();
    }
}
