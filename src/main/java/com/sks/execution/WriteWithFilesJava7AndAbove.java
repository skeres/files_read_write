package com.sks.execution;

import com.sks.utils.Util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteWithFilesJava7AndAbove {



    public static void main(String[] args) {
        WriteWithFilesJava7AndAbove clazz=new WriteWithFilesJava7AndAbove();
        clazz.writeFile();
    }



    public void writeFile(){
        //generate directories
        Util util=new Util();
        util.generatePath("42");
        util.generateRandomDatasAsList();
        String myFileName="simpleTextfile.02";


        final String NEW_LINE = System.lineSeparator();
        Path path = Paths.get(util.getDirectory()+"/"+myFileName);
        for(String s : util.getStringList()) {
            try {
                // Create mode, does not append datas to an existing file => overriding datas
                // if file does not exist, create and write it
                // if the file exists, override the content
                Files.write(path, (s+NEW_LINE).getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);

                // Append mode
                // if the file exists, append string to the end of file.
                //Files.write(path, (s+NEW_LINE).getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
