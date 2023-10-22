package org.example;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    static Logger LOGGER;

    static {
        try(FileInputStream ins = new FileInputStream("/Users/sasha/IdeaProjects/SecondLab/src/main/java/"+
                "org/example/log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Main.class.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LOGGER.log(Level.INFO,"Start of the program");
        Main a = new Main();
        a.performer("/Users/sasha/IdeaProjects/SecondLab/test2.txt");
    }

    public void performer(String fileName) {
        BufferedReader reader;
        Stack<Double> stack = new Stack<>();
        Map<String, Double> map = new HashMap<>();
        try {
            LOGGER.log(Level.INFO,"Read the file");
            reader = new BufferedReader(new FileReader(fileName));
            String command = reader.readLine();
            while(command!=null) {
                String[] parts = command.split(" ");
                List<String> arguments = Arrays.asList(Arrays.copyOfRange(parts, 1, parts.length));
                if (parts[0].contains("#")) {
                    command = reader.readLine();
                    continue;
                }
                Factory factory = new Factory(stack, arguments, map);
                try {
                    LOGGER.log(Level.INFO,"The factory creates an instance of the class for the passed command");
                    Command calculate = factory.create(parts[0]);
                    calculate.toDo();
                } catch (Exception e) {
                    LOGGER.warning(e.getMessage() + ": " );
                    System.out.println(e.getMessage());
                }
                LOGGER.log(Level.INFO,"Reading a new command");
                command = reader.readLine();
            }
            LOGGER.log(Level.INFO,"File is closing");
            reader.close();
        } catch (IOException e) {
            LOGGER.log(Level.WARNING,"Error while reading file:", e);
            System.err.println("Error while reading file:" + e.getLocalizedMessage());
        }
    }
}