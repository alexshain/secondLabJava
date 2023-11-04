package org.example;

import java.util.Stack;

public class Minus extends SingleOperator{
    Minus(Stack<Double> stack) {
        super(stack);
    }

    @Override
    public void toDo() throws InvalidStackLengthException {
        Stack<Double> stack1 = getStack();
        getStack().push(stack1.pop() - stack1.pop());
    }
}
