package ru.chichkov.database.patternDB;

public interface InterfaceBD {
    <T> T convert(String element, Class<T> type);
}
