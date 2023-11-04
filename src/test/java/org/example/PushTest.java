package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class PushTest {
    Stack<Double> stack = new Stack<>();
    List<String> arguments = new ArrayList<>();
    Map<String,Double> parameters = new HashMap<>();

    @Test
    void test1() {
        Assert.assertEquals(stack.size(), 0);
        arguments.add("5");
        Push push = new Push(stack, arguments, parameters);
        try {
            push.toDo();
            Assert.assertEquals(stack.size(), 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void test2() {
        arguments.clear();
        arguments.add("a");
        Push push = new Push(stack, arguments, parameters);
        Assert.assertThrows(Exception.class, push::toDo);
    }

    @Test
    void test3() {
        parameters.put("a", 5.);
        Push push = new Push(stack, arguments, parameters);
        stack.clear();
        try {
            push.toDo();
            Assert.assertEquals(stack.size(), 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void test4() {
        arguments.clear();
        Push push = new Push(stack, arguments, parameters);
        Assert.assertThrows(Exception.class, push::toDo);
    }
}
