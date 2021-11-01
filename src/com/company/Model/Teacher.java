package com.company.Model;

import java.util.List;

public class Teacher extends Person{
    private long teacherId;
    private List<Course> courses;

    private static long teacherIdCounter = 0;

    public Teacher(String firstName, String lastName){
        super(firstName, lastName);
        this.teacherId = teacherIdCounter;
        teacherIdCounter++;
        this.courses = List.of();
    }

    public long getTeacherId() {
        return teacherId;
    }
}
