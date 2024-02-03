package com.pacioli.simp.entity;

import helpInterfaces.TextFiller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SeansInf implements TextFiller {
    private int curSeans;
    private String curDt;

    public int getCurSeans() {
        return curSeans;
    }

    public void setCurSeans(int curSeans) {
        this.curSeans = curSeans;
    }

    public String getCurDt() {
        return curDt;
    }

    public void setCurDt(String curDt) {
        this.curDt = curDt;
    }

    public void updateSession(){
        setCurSeans(++curSeans);
        setCurDt(LocalDateTime.now().toString());
        addToFile();
    }

    @Override
    public void addToFile() {
        List<String> list = new ArrayList<>();
        String s1 = Integer.toString(curSeans);
        list.add(s1);
        list.add(curDt);
        try {
            Files.write(Paths.get("/Users/alexandrzhidkov/Documents/УчебаJava/Курс/Spring/Lesson3/Hw3Mvc/WW2/simp/src/main/java/fileRep/data.txt"), list, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void readFile() {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("/Users/alexandrzhidkov/Documents/УчебаJava/Курс/Spring/Lesson3/Hw3Mvc/WW2/simp/src/main/java/fileRep/data.txt"));
            String line = reader.readLine();
            if (line == null) {
                setCurSeans(1);
                setCurDt(LocalDateTime.now().toString());
                addToFile();
            } else {
                setCurSeans(Integer.parseInt(line));
                line = reader.readLine();
                setCurDt(line);
                updateSession();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
