package org.example;

import java.util.Stack;

public abstract class SingleOperator implements Command{
    Stack<Double> stack;

    SingleOperator(Stack<Double> stack) {
        this.stack = stack;
    }

    public Stack<Double> getStack() throws Exception{
        if(stack.size() < 2) {throw new Exception("Not enough arguments on stack");}
        return stack;
    }
}
