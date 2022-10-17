package com.mumu.learn.json;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

public class Student {

    private String name;
    private int age;

    public String public1;
    public String public2;
    public String public3;
    protected String protect1;
    int default1;

    public Student(){
        // TODO
    }

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString(){
        // TODO
        return "student [name = " + name + " , " + "age = " + age + "]";
    }
}
