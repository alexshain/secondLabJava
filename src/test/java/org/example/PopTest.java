package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class PopTest {
    Stack<Double> stack = new Stack<>();

    @Test
    void test1() {
        try {
            Pop pop = new Pop(stack);
            Assert.assertThrows(Exception.class, pop::toDo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void test2() {
        stack.push(1.);
        Assert.assertEquals(stack.size(), 1);
        try {
            Pop pop = new Pop(stack);
            pop.toDo();
            Assert.assertEquals(stack.size(), 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
