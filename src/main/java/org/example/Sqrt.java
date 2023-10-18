package org.example;

import java.util.List;
import java.util.Stack;

public class Sqrt implements Command {
    Stack<Double> stack;

    Sqrt(Stack<Double> stack) {
        this.stack = stack;
    }
    @Override
    public void toDo() throws Exception{
        if(stack.isEmpty()) {throw new Exception("Stack is empty");}
        stack.push(Math.pow(stack.pop(), 0.5));
    }
}
