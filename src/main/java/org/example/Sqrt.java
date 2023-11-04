package org.example;

import java.util.Stack;

public class Sqrt implements Command {
    Stack<Double> stack;
    Sqrt(Stack<Double> stack) {
        this.stack = stack;
    }
    @Override
    public void toDo() throws InvalidStackLengthException {
        if(stack.isEmpty()) {throw new InvalidStackLengthException("Stack is empty");}
        stack.push(Math.pow(stack.pop(), 0.5));
    }
}
