package org.example;

import java.util.Stack;

public class Divide extends SingleOperator{
    Divide (Stack<Double> stack) {
        super(stack);
    }

    @Override
    public void toDo() throws InvalidStackLengthException, ArithmeticException {
        Stack<Double> stack = getStack();
        Double var1 = stack.pop();
        Double var2 = stack.pop();
        if(var2 == 0.) throw new ArithmeticException("Dividing by zero");
        getStack().push(var1 / var2);
    }
}
