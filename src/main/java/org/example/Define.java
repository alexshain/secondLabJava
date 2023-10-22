package org.example;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Define implements Command {
    static Logger LOGGER;

    static {
        try(FileInputStream ins = new FileInputStream("/Users/sasha/IdeaProjects/SecondLab/src/main/java/"+
                "org/example/log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Define.class.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    Map<String,Double> parameters;
    List<String> arguments;
    Define(Stack<Double> stack, List<String> arguments, Map<String,Double> parameters) {
        this.arguments = arguments;
        this.parameters = parameters;
    }

    @Override
    public void toDo() throws Exception{
        char[] ch1 = arguments.get(0).toCharArray();
        char[] ch2 = arguments.get(1).toCharArray();
        LOGGER.log(Level.INFO,"Parameter initialization");
        if(Character.isDigit(ch1[0])) {
            throw new Exception("Parameter must not be a number or start with a number");
        }
        if(arguments.size() != 2) {
            throw new Exception("Invalid amount of arguments");
        }
        if(Character.isLetter(ch2[0])) {
            throw new Exception("Value must not be a letter");
        }
        parameters.put(arguments.get(0), Double.parseDouble(arguments.get(1)));
    }
}
