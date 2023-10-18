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
    public void toDo() throws Exception{
        char[] ch = arguments.get(0).toCharArray();
        if(Character.isDigit(ch[0])) {
            throw new Exception("Parameter must not be a number or start with a number");
        }
        parameters.put(arguments.get(0), Double.parseDouble(arguments.get(1)));
    }
}
