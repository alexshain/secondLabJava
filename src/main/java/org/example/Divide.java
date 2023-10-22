package org.example;

import java.io.FileInputStream;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Divide extends SingleOperator{
    static Logger LOGGER;

    static {
        try(FileInputStream ins = new FileInputStream("/Users/sasha/IdeaProjects/SecondLab/src/main/java/"+
                "org/example/log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Divide.class.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    Divide (Stack<Double> stack) {
        super(stack);
    }

    @Override
    public void toDo() throws Exception {
        LOGGER.log(Level.INFO,"Dividing the top two elements of the stack");
        Stack<Double> stack1 = super.getStack();
        super.getStack().push(stack1.pop() / stack1.pop());
    }
}
