package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class PlusTest {
    Stack<Double> stack = new Stack<>();

    @Test
    void test1() {
        try {
            Plus divide = new Plus(stack);
            Assert.assertThrows(Exception.class, divide::toDo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void test2() {
        stack.push(2.);
        stack.push(10.);
        try {
            Plus divide = new Plus(stack);
            divide.toDo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(stack.peek(), 12.);
    }

    @Test
    void test3() {
        stack.clear();
        stack.push(1.);
        try {
            Plus divide = new Plus(stack);
            divide.toDo();
            Assert.assertThrows(Exception.class, divide::toDo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
