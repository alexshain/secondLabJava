package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class FactoryTest {
    Stack<Double> stack = new Stack<>();
    Map<String, Double> map = new HashMap<>();
    List<String> arguments = new ArrayList<>();
    String[] commands = {"+"};

    @Test
    void test1() {
        Factory factory = new Factory(stack, arguments, map);
        try {
            Assert.assertThrows(Exception.class, factory.create("hui_pizda_skovoroda")::toDo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void test2() {
        Factory factory = new Factory(stack, arguments, map);
        try {
            Command calculate = factory.create("PUSH");
            Assert.assertEquals(calculate.getClass().toString(),"class org.example.Push");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void test3() {
        Factory factory = new Factory(stack, arguments, map);
        try {
            Command calculate = factory.create("POP");
            Assert.assertEquals(calculate.getClass().toString(),"class org.example.Pop");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void test4() {
        Factory factory = new Factory(stack, arguments, map);
        try {
            Command calculate = factory.create("SQRT");
            Assert.assertTrue(calculate.getClass().toString().contains("class org.example.Sqrt"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void test5() {
        Factory factory = new Factory(stack, arguments, map);
        try {
            Command calculate = factory.create("PRINT");
            Assert.assertEquals(calculate.getClass().toString(),"class org.example.Print");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void test6() {
        Factory factory = new Factory(stack, arguments, map);
        try {
            Command calculate = factory.create("DEFINE");
            Assert.assertEquals(calculate.getClass().toString(),"class org.example.Define");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void test7() {
        Factory factory = new Factory(stack, arguments, map);
        try {
            Command calculate = factory.create("+");
            Assert.assertEquals(calculate.getClass().toString(),"class org.example.Plus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void test8() {
        Factory factory = new Factory(stack, arguments, map);
        try {
            Command calculate = factory.create("-");
            Assert.assertEquals(calculate.getClass().toString(),"class org.example.Minus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void test9() {
        Factory factory = new Factory(stack, arguments, map);
        try {
            Command calculate = factory.create("/");
            Assert.assertEquals(calculate.getClass().toString(),"class org.example.Divide");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void test10() {
        Factory factory = new Factory(stack, arguments, map);
        try {
            Command calculate = factory.create("*");
            Assert.assertTrue(calculate.getClass().toString().contains("class org.example.Multiple"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
