package org.example;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Plus extends SingleOperator{
    static Logger LOGGER;

    static {
        try(FileInputStream ins = new FileInputStream("/Users/sasha/IdeaProjects/SecondLab/src/main/java/"+
                "org/example/log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Plus.class.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    Plus(Stack<Double> stack) {
        super(stack);
    }

    @Override
    public void toDo() throws Exception {
        LOGGER.log(Level.INFO,"Addition the top two elements of the stack");
        Stack<Double> stack1 = super.getStack();
        super.getStack().push(stack1.pop() + stack1.pop());
    }
}
