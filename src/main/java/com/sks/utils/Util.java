package com.sks.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Util {

    private List<String> stringList = new ArrayList<>();
    private String directory;


    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }


    public void generateRandomDatasAsList() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        for (int i = 0; i < 100; i++) {
            this.stringList.add(RandomStringUtils.random(length, useLetters, useNumbers));
        }
    }

    public void generatePath(String directory) {
        String myPath = System.getProperty("user.home") + "/" + directory;
        File directories = new File(myPath);
        if (!directories.exists()) {
            directories.mkdirs();
        }
        this.directory = myPath;
    }


}

