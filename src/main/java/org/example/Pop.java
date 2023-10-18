package org.example;

import java.util.Stack;

public class Pop implements Command {
    Stack<Double> stack;

    Pop(Stack<Double> stack) {
        this.stack = stack;
    }
    @Override
    public void toDo() throws Exception {
        if(stack.isEmpty()) {throw new Exception("Stack is empty");}
        stack.pop();
    }
}
