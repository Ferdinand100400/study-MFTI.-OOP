package ru.chichkov.database.patternDB;

public class IntegerBD implements InterfaceBD {
    @Override
    public <T> T convert(String element, Class<T> type) {
        Integer res = (Integer) element.length();
        return (T) res;
    }
}
