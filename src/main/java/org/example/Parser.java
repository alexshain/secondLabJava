package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser {
    private static final Logger LOGGER = Logger.getLogger(Parser.class.getName());
    List<String> stringFile;

    Parser(List<String> stringFile) {
        this.stringFile = stringFile;
    }

    public void parser(String fileName) {
        BufferedReader reader;
        try {
            LOGGER.log(Level.INFO,"Read the file");
            reader = new BufferedReader(new FileReader(fileName));
            String command = reader.readLine();
            while(command!=null) {
                stringFile.add(command);
                if (command.toCharArray()[0] == '#') {
                    command = reader.readLine();
                    continue;
                }
                LOGGER.log(Level.INFO,"Reading a new command");
                command = reader.readLine();
            }
            LOGGER.log(Level.INFO,"File is closing");
            reader.close();
        } catch (IOException e) {
            LOGGER.log(Level.WARNING,"Error while reading file:", e);
            System.err.println("Error while reading file:" + e.getLocalizedMessage());
        }
    }
}
