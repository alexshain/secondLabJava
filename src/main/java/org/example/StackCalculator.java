package org.example;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StackCalculator {

    private static final Logger LOGGER = Logger.getLogger(StackCalculator.class.getName());

    static Stack<Double> stack = new Stack<>();
    static Map<String, Double> map = new HashMap<>();
    static List<String> arguments;
    static List<String> stringFile = new ArrayList<>();

    public void calculate() {
        Parser parser = new Parser(stringFile);
        parser.parser("/Users/sasha/IdeaProjects/SecondLab/test2.txt");
        for(String item : stringFile) {
            String[] parts = item.split(" ");
            arguments = Arrays.asList(Arrays.copyOfRange(parts, 1, parts.length));
            Factory factory = new Factory(stack, arguments, map);
            try {
                LOGGER.log(Level.INFO,"The factory creates an instance of the class for the passed command");
                Command calculate = factory.create(parts[0]);
                calculate.toDo();
            } catch (Exception e) {
                LOGGER.warning(e.getClass() + ": " + e.getMessage());
                System.out.println(e.getMessage());
            }
        }
    }
}
