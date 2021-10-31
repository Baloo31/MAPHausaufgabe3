package com.company.Model;

import java.util.List;

public class Teacher extends Person{
    private List<Course> courses;

    public Teacher(String firstName, String lastName){
        super(firstName, lastName);
        this.courses = List.of();
    }
}
