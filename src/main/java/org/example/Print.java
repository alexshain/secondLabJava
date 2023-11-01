package org.example;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Print implements Command {
    private static final Logger LOGGER = Logger.getLogger(Print.class.getName());
    Stack<Double> stack;

    Print(Stack<Double> stack) {
        this.stack = stack;
    }
    @Override
    public void toDo() throws InvalidStackLengthException {
        LOGGER.log(Level.INFO,"Print top of stack");
        if(stack.isEmpty()) {throw new InvalidStackLengthException("Stack is empty");}
        System.out.println(stack.peek());
    }
}
