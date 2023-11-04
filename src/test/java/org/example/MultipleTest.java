package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class MultipleTest {
    Stack<Double> stack = new Stack<>();

    @Test
    void test1() {
        try {
            Multiple divide = new Multiple(stack);
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
            Multiple divide = new Multiple(stack);
            divide.toDo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(stack.peek(), 20.);
    }

    @Test
    void test3() {
        stack.clear();
        stack.push(1.);
        try {
            Multiple divide = new Multiple(stack);
            divide.toDo();
            Assert.assertThrows(Exception.class, divide::toDo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
