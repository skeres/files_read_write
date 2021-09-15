package com.sks.execution;

import com.sks.utils.Util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteWithJava8AndAbove {



    public static void main(String[] args) {
        WriteWithJava8AndAbove clazz=new WriteWithJava8AndAbove();
        clazz.writeFile("42");
    }



    public String writeFile(String targetDirectory){
        //generate directories
        Util util=new Util();
        util.generatePath(targetDirectory);
        util.generateRandomDatasAsList();
        String myFileName="simpleTextfile.03";


        final String NEW_LINE = System.lineSeparator();
        final String pathPlusFileName=util.getDirectory()+"/"+myFileName;
        Path path = Paths.get(pathPlusFileName);

        /**
         * source : https://mkyong.com/java/java-how-to-create-and-write-to-a-file/
         * In Java 8, we can use the Files.newBufferedWriter to directly create a BufferedWriter object.
         */
        for(String content : util.getStringList()) {
            // default utf_8
            try (BufferedWriter bw = Files.newBufferedWriter(path,StandardCharsets.UTF_8,StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
                bw.write(content);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return pathPlusFileName;
    }

}
