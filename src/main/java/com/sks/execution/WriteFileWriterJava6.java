package com.sks.execution;

import com.sks.utils.Util;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class WriteFileWriterJava6 {



    public static void main(String[] args) {
        WriteFileWriterJava6 clazz=new WriteFileWriterJava6();
        clazz.writeFile();
    }



    public void writeFile(){
        //generate directories
        Util util=new Util();
        util.generatePath("42");
        util.generateRandomDatasAsList();
        String myFileName="simpleTextfile.01";


        try (FileWriter fw = new FileWriter(util.getDirectory()+"/"+myFileName, Charset.forName("UTF8"));
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (String s : util.getStringList()) {
                bw.write(s);
                bw.newLine();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("ending");
        }

    }

}
