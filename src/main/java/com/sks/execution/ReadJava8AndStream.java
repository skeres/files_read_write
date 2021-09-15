package com.sks.execution;

import com.sks.utils.Util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class ReadJava8AndStream {

    public static void main(String[] args) {
        ReadJava8AndStream clazz=new ReadJava8AndStream();
        clazz.readFile();
    }



    public void readFile(){

        //create file first
        WriteWithJava8AndAbove writeWithJava8AndAbove=new WriteWithJava8AndAbove();
        String thePath=writeWithJava8AndAbove.writeFile("43");

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(thePath))) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
