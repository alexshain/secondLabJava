package org.example;

import java.io.FileInputStream;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Plus extends SingleOperator{
    private static final Logger LOGGER = Logger.getLogger(Plus.class.getName());
    Plus(Stack<Double> stack) {
        super(stack);
    }

    @Override
    public void toDo() throws InvalidStackLengthException {
        LOGGER.log(Level.INFO,"Addition the top two elements of the stack");
        Stack<Double> stack1 = getStack();
        getStack().push(stack1.pop() + stack1.pop());
    }
}
