package org.example;

import java.util.Stack;

public class Divide extends SingleOperator{
    Divide (Stack<Double> stack) throws Exception{
        super(stack);
    }

    @Override
    public void toDo() {
        super.getStack().push(super.getStack().pop() / super.getStack().pop());
    }
}
