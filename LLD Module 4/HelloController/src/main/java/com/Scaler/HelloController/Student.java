package com.Scaler.HelloController;

public class Student {
    String name;
    int age;
    String univ_name;

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

    public String getUniv_name() {
        return univ_name;
    }

    public void setUniv_name(String univ_name) {
        this.univ_name = univ_name;
    }

    public Student(String name, int age, String univ_name) {
        this.name = name;
        this.age = age;
        this.univ_name = univ_name;
    }
}
