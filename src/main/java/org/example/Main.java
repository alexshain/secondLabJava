package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //Сделаю с файла, когда тесты писать буду
        String command = in.nextLine();
        Stack<Double> stack = new Stack<>();
        Map<String, Double> map = new HashMap<>();
        while (!command.contains("end")) {
            String[] parts = command.split(" ");
            List<String> arguments = Arrays.asList(Arrays.copyOfRange(parts, 1, parts.length));
            if (parts[0].contains("#")) {
                command = in.nextLine();
                continue;
            }
            Factory factory = new Factory(stack, arguments, map);
            var calculate = factory.create(parts[0]);
            try {
                calculate.toDo();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            command = in.nextLine();
        }
        in.close();
    }
}