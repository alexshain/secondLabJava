package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in); //Сделаю с файла, когда тесты писать буду
        //String fileName = in.nextLine();
        Main a = new Main();
        a.performer("/Users/sasha/IdeaProjects/SecondLab/file.txt");
        //in.close();
    }

    public void performer(String fileName) {
        BufferedReader reader;
        Stack<Double> stack = new Stack<>();
        Map<String, Double> map = new HashMap<>();
        try {
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
                    var calculate = factory.create(parts[0]);
                    calculate.toDo();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                command = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            System.err.println("Error while reading file:" + e.getLocalizedMessage());
        }
    }
}