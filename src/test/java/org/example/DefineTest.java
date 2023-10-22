package org.example;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class DefineTest {
    Stack<Double> stack = new Stack<>();
    Map<String, Double> map = new HashMap<>();
    @Test
    void test1() {
        String[] testArr1 = {"a", "4"};
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList(testArr1));
        Define define = new Define(stack, arguments, map);
        try {
            define.toDo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Assert.assertTrue(map.containsKey("a"));
    }

    @Test
    void test2() {
        String[] testArr = {"a", "a"};
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList(testArr));
        Define define1 = new Define(stack, arguments, map);
        Assert.assertThrows(Exception.class, define1::toDo);
    }

    @Test
    void test3() {
        String[] testArr = {"1", "1"};
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList(testArr));
        Define define1 = new Define(stack, arguments, map);
        Assert.assertThrows(Exception.class, define1::toDo);
    }
}
