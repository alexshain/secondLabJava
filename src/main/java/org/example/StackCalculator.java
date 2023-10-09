package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class StackCalculator {
    public void startWork() {
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        Stack<ValueGetter> values = new Stack<>();
        StackValues stack = new StackValues();
        stack.setStack(values);
        Map<String,Double> parameters = new HashMap<>();
        while (!command.contains("end")) {
            String[] parts = command.split(" ");
            if(parts[0].contains("#")) {
                command = in.nextLine();
                continue;
            }
            switch (parts.length) {
                case 1:
                    switch (parts[0]) {
                        case "":
                            break;
                        case "POP":
                            stack.popStack();
                            break;
                        case "PRINT":
                            System.out.println(stack.lookTopStack().getValue());
                            break;
                        case "SQRT":
                            values.push(new ValueGetter(Math.pow(stack.getValueFromStack().getValue(), 0.5)));
                            break;
                        case "+":
                            values.push(new ValueGetter(stack.getValueFromStack().getValue() + stack.getValueFromStack().getValue()));
                            break;
                        case "-":
                            values.push(new ValueGetter(stack.getValueFromStack().getValue() - stack.getValueFromStack().getValue()));
                            break;
                        case "*":
                            values.push(new ValueGetter(stack.getValueFromStack().getValue() * stack.getValueFromStack().getValue()));
                            break;
                        case "/":
                            values.push(new ValueGetter(stack.getValueFromStack().getValue() / stack.getValueFromStack().getValue()));
                            break;
                        default:
                            System.out.println("There is no such command or invalid amount of arguments");
                            break;
                    }
                    break;
                case 2:
                    if(parts[0].equals("PUSH")) {
                        if (parameters.containsKey(parts[1])) {
                            values.push(new ValueGetter(parameters.get(parts[1])));
                            break;
                        } else {
                            try {
                                values.push(new ValueGetter(Double.valueOf(parts[1])));
                                break;
                            } catch (Exception e) {
                                System.out.println("This parameter was not defined");
                                break;
                            }
                        }
                    } else {
                        System.out.println("There is no such command or invalid amount of arguments");
                        break;
                    }
                case 3:
                    char[] ch = parts[1].toCharArray();
                    if(parts[0].equals("DEFINE")) {
                        if(Character.isDigit(ch[0])) {
                            System.out.println("Parameter must not be a number or start with a number");
                            break;
                        } else {
                            parameters.put(parts[1], Double.parseDouble(parts[2]));
                            break;
                        }
                    } else {
                        System.out.println("There is no such command or invalid amount of arguments");
                        break;
                    }
                default:
                    System.out.println("Invalid amount of arguments");
                    break;
            }
            command = in.nextLine();
        }
        in.close();
    }
}
