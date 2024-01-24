package com.college.AdminMS.model;

import javax.persistence.*;

public class Student {

    private int id;

    private String name;

    private String password;

    private String mail;

    private int course;

    public Student() {
    }

    public Student(int id, String name, String password, String mail, int course) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.course = course;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

}
