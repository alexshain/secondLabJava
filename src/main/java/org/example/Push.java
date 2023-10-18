package org.example;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Push implements Command {
    Stack<Double> stack;
    List<String> arguments;
    Map<String,Double> parameters;
    Push(Stack<Double> stack, List<String> arguments, Map<String,Double> parameters) {
        this.stack = stack;
        this.arguments = arguments;
        this.parameters = parameters;
    }
    @Override
    public void toDo() throws Exception {
        if(arguments.isEmpty()) {throw new Exception("No passed arguments");}
        try {
            for (String item : arguments) {
                if (parameters.containsKey(item)) {
                    stack.push(parameters.get(item));
                } else {
                    stack.push(Double.valueOf(item));
                }
            }
        } catch (Exception e) {
            System.out.println("Undefined parameter");
        }
    }
}
