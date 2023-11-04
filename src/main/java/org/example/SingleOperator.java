package org.example;

import java.util.Stack;

public abstract class SingleOperator implements Command{
    Stack<Double> stack;

    SingleOperator(Stack<Double> stack) {
        this.stack = stack;
    }

    Stack<Double> getStack() throws InvalidStackLengthException{
        if(stack.size() < 2) {throw new InvalidStackLengthException("Not enough parameters on stack");}
        return stack;
    }

}
