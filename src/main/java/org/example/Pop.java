package org.example;

import java.util.Stack;

public class Pop implements Command {
    Stack<Double> stack;

    Pop(Stack<Double> stack) {
        this.stack = stack;
    }
    @Override
    public void toDo() throws InvalidStackLengthException {
        if(stack.isEmpty()) {throw new InvalidStackLengthException("Stack is empty");}
        stack.pop();
    }
}
