package ru.chichkov.geometry.points;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Attribute {
    private String name;
    private Object value;

}
