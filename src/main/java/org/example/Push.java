package org.example;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Push implements Command {
    static Logger LOGGER;

    static {
        try(FileInputStream ins = new FileInputStream("/Users/sasha/IdeaProjects/SecondLab/src/main/java/"+
                "org/example/log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Push.class.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    Stack<Double> stack;
    List<String> arguments;
    Map<String,Double> parameters;
    Push(Stack<Double> stack, List<String> arguments, Map<String,Double> parameters) {
        this.stack = stack;
        this.arguments = arguments;
        this.parameters = parameters;
    }
    @Override
    public void toDo() throws Exception {
        LOGGER.log(Level.INFO,"Push element(s) on stack");
        if(arguments.isEmpty()) {throw new Exception("No passed arguments");}
        try {
            for (String item : arguments) {
                if (parameters.containsKey(item)) {
                    stack.push(parameters.get(item));
                } else {
                    stack.push(Double.valueOf(item));
                }
            }
        } catch (Exception e) {
            throw new Exception("Undefined parameter");
        }
    }
}
