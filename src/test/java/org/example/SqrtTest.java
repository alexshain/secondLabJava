package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class SqrtTest {
    Stack<Double> stack = new Stack<>();

    @Test
    void test1() {
        stack.push(4.);
        Sqrt sqrt = new Sqrt(stack);
        try {
            sqrt.toDo();
            Assert.assertEquals(stack.pop(),2.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void test2() {
        Sqrt sqrt = new Sqrt(stack);
        Assert.assertThrows(Exception.class, sqrt::toDo);
    }
}
