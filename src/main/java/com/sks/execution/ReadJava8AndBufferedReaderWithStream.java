package com.sks.execution;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadJava8AndBufferedReaderWithStream {

    public static void main(String[] args) {
        ReadJava8AndBufferedReaderWithStream clazz=new ReadJava8AndBufferedReaderWithStream();
        clazz.readFile();
    }



    public void readFile(){

        //create file first
        WriteWithJava8AndAbove writeWithJava8AndAbove=new WriteWithJava8AndAbove();
        String thePath=writeWithJava8AndAbove.writeFile("44");

        //read file with a BufferedReader return content as Stream
        List<String> list = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(thePath))) {

            //br returns as stream and convert it into a List
            list = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(System.out::println);


    }
}
