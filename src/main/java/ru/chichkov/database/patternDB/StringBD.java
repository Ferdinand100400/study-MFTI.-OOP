package ru.chichkov.database.patternDB;

public class StringBD implements InterfaceBD {
    @Override
    public <T> T convert(String element, Class<T> type) {
        return (T) element;
    }
}
