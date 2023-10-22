package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Stack;

public class PrintTest {
    Stack<Double> stack = new Stack<>();

    @Test
    void test1() {
        stack.push(5.0);
        Double consoleOutput;
        PrintStream originalOut = System.out;
        Print print = new Print(stack);
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);
            print.toDo();
            capture.flush();
            consoleOutput = Double.parseDouble(outputStream.toString()) ;
            System.setOut(originalOut);
            Assert.assertEquals(consoleOutput, 5.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
