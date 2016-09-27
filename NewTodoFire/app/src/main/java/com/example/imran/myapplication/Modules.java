package com.example.imran.myapplication;

/**
 * Created by imran on 9/26/2016.
 */

public class Modules {
    private int id ;
    private String name;
    private int age;
    private boolean ischeck;

    public Modules(int id, String name, int age, boolean ischeck) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ischeck = ischeck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean ischeck() {
        return ischeck;
    }

    public void setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
    }
}
