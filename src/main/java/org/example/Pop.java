package org.example;

import java.io.FileInputStream;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Pop implements Command {
    static Logger LOGGER;

    static {
        try(FileInputStream ins = new FileInputStream("/Users/sasha/IdeaProjects/SecondLab/src/main/java/"+
                "org/example/log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Pop.class.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    Stack<Double> stack;

    Pop(Stack<Double> stack) {
        this.stack = stack;
    }
    @Override
    public void toDo() throws Exception {
        LOGGER.log(Level.INFO,"Delete the top element of the stack");
        if(stack.isEmpty()) {throw new Exception("Stack is empty");}
        stack.pop();
    }
}
