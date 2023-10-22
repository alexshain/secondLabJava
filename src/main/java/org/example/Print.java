package org.example;

import java.io.FileInputStream;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Print implements Command {
    static Logger LOGGER;

    static {
        try(FileInputStream ins = new FileInputStream("/Users/sasha/IdeaProjects/SecondLab/src/main/java/"+
                "org/example/log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Print.class.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    Stack<Double> stack;

    Print(Stack<Double> stack) {
        this.stack = stack;
    }
    @Override
    public void toDo() throws Exception {
        LOGGER.log(Level.INFO,"Print top of stack");
        if(stack.isEmpty()) {throw new Exception("Stack is empty");}
        System.out.println(stack.peek());
    }
}
