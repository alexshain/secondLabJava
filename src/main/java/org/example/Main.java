package org.example;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {         // Не знаю правильно ли я все сделал, но стало не сильно аккуратней
        LOGGER.log(Level.INFO,"Start of the program");
        StackCalculator calculator = new StackCalculator();
        calculator.calculate();
    }
}