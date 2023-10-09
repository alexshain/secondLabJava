package org.example;

import java.util.Stack;

public class StackValues {
    Stack<ValueGetter> values;
    public ValueGetter getValueFromStack() {
        return values.pop();
    }
    public void popStack() {
        values.pop();
    }
    public ValueGetter lookTopStack() {
        return values.peek();
    }

    public void setStack(Stack<ValueGetter> values) {
        this.values = values;
    }
}
