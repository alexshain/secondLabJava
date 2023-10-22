package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class SingleOperator implements Command{
    Stack<Double> stack;

    SingleOperator(Stack<Double> stack) throws Exception{
        if(stack.size() < 2) {throw new Exception("Not enough parameters on stack");}
        this.stack = stack;
    }

    Stack<Double> getStack() {
        return stack;
    }
}
