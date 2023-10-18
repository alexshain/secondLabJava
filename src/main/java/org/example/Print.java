package org.example;

import java.util.Stack;

public class Print implements Command {
    Stack<Double> stack;

    Print(Stack<Double> stack) {
        this.stack = stack;
    }
    @Override
    public void toDo() throws Exception {
        if(stack.isEmpty()) {throw new Exception("Stack is empty");}
        System.out.println(stack.peek());
    }
}
