package org.example;

import java.util.Stack;

public class Plus extends SingleOperator{
    Plus(Stack<Double> stack) throws Exception{
        super(stack);
    }

    @Override
    public void toDo() throws Exception {
        super.getStack().push(super.getStack().pop() + super.getStack().pop());
    }
}
