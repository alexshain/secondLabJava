package org.example;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Define implements Command {
    Map<String,Double> parameters;
    List<String> arguments;
    Define(Stack<Double> stack, List<String> arguments, Map<String,Double> parameters) {
        this.arguments = arguments;
        this.parameters = parameters;
    }

    @Override
    public void toDo() throws InvalidArgumentsException {
        char[] ch1 = arguments.get(0).toCharArray();
        char[] ch2 = arguments.get(1).toCharArray();
        if(Character.isDigit(ch1[0])) {
            throw new InvalidArgumentsException("Parameter must not be a number or start with a number");
        }
        if(arguments.size() != 2) {
            throw new InvalidArgumentsException("Invalid amount of arguments");
        }
        if(Character.isLetter(ch2[0])) {
            throw new InvalidArgumentsException("Value must not be a letter");
        }
        parameters.put(arguments.get(0), Double.parseDouble(arguments.get(1)));
    }
}
