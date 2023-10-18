package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;

public class Factory {
    private final Properties properties;
    Stack<Double> stack;
    List<String> arguments;
    Map<String, Double> map;

    public Factory(Stack<Double> stack, List<String> arguments, Map<String, Double> map) {
        properties = new Properties();
        try {
            properties.load(new FileReader("/Users/sasha/IdeaProjects/" +
                    "SecondLab/src/main/resources/commands.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.stack = stack;
        this.arguments = arguments;
        this.map = map;
    }

    public Command create(String name) {
        var fullName = "org.example." + properties.getProperty(name);

        Class<?> targetClass;
        try {
            targetClass = Class.forName(fullName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Command instance;
        try {
            instance = (Command) targetClass.getDeclaredConstructor(
                    Stack.class, List.class, Map.class).newInstance(stack, arguments, map);
        } catch (InstantiationException | IllegalAccessException
                 | NoSuchMethodException | InvocationTargetException e) {
            try {
                instance = (Command) targetClass.getDeclaredConstructor(Stack.class).newInstance(stack);
            } catch (InstantiationException | IllegalAccessException
                     | NoSuchMethodException | InvocationTargetException ex) {
                throw new RuntimeException(ex);
            }
        }
        return instance;
    }
}
