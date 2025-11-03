package ru.chichkov.DataBaseH2.dao;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SimpleDAO<T> {

    Class<T> cls;
    Connection connection;

    public SimpleDAO(Class<T> cls, Connection connection) {
        this.cls = cls;
        this.connection = connection;
    }

    @SneakyThrows
    public List<T> findAll() {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + cls.getSimpleName());
        List<T> objects = new ArrayList<>();
        List<Field> fields = List.of(cls.getDeclaredFields());
        for (Field field : fields) {
            field.setAccessible(true);
        }
        while (resultSet.next()) {
            T obj = cls.getDeclaredConstructor().newInstance();
            for (Field field : fields) {
                Object value = resultSet.getObject(field.getName());
                field.set(obj, value);
            }
            objects.add(obj);
        }
        return objects;
    }

    @SneakyThrows
    public Optional<T> findByID(int id) {
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + cls.getSimpleName() + " WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            T obj = cls.getDeclaredConstructor().newInstance();
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                Object value = resultSet.getObject(field.getName());
                field.set(obj, value);
            }
            return Optional.of(obj);
        }
        return Optional.empty();
    }

    @SneakyThrows
    public int updateAll(Map<String, Object> updates) {
        String setValues = updates.keySet().stream()
                .map(column -> column + " = ?")
                .collect(Collectors.joining(", "));
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE " + cls.getSimpleName() + " SET " + setValues);
        int paramIndex = 1;
        for (Object value : updates.values()) {
            preparedStatement.setObject(paramIndex++, value);
        }
        return preparedStatement.executeUpdate();
    }

    @SneakyThrows
    public int deleteAll(Map<String, Object> deletes) {
        String setValues = deletes.keySet().stream()
                .map(column -> column + " = ?")
                .collect(Collectors.joining("OR "));
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM " + cls.getSimpleName() + " WHERE " + setValues);
        int paramIndex = 1;
        for (Object value : deletes.values()) {
            preparedStatement.setObject(paramIndex++, value);
        }
        return preparedStatement.executeUpdate();
    }
}