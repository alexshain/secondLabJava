package org.example;

import java.util.Stack;

public class Minus extends SingleOperator{
    Minus(Stack<Double> stack) {
        super(stack);
    }

    @Override
    public void toDo() throws Exception {
        super.getStack().push(super.getStack().pop() - super.getStack().pop());
    }
}
