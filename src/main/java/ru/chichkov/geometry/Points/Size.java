package ru.chichkov.geometry.Points;

public class Size extends Attribute {
    public Size(int value) {
        super("Size", value);
    }

    @Override
    public Integer getValue() {
        return (int) super.getValue();
    }
}
