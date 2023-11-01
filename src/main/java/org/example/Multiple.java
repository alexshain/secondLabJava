package org.example;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Multiple extends SingleOperator{
    private static final Logger LOGGER = Logger.getLogger(Multiple.class.getName());
    Multiple (Stack<Double> stack) {
        super(stack);
    }

    @Override
    public void toDo() throws InvalidStackLengthException {
        LOGGER.log(Level.INFO,"Multiplication the top two elements of the stack");
        Stack<Double> stack1 = getStack();
        getStack().push(stack1.pop() * stack1.pop());
    }
}
