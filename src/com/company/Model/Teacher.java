package com.company.Model;

import java.util.LinkedList;
import java.util.List;

public class Teacher extends Person{
    private long teacherId;
    private List<Course> courses;

    private static long teacherIdCounter = 0;

    public Teacher(String firstName, String lastName){
        super(firstName, lastName);
        this.teacherId = teacherIdCounter;
        teacherIdCounter++;
        this.courses = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                '}';
    }

    public long getTeacherId() {
        return teacherId;
    }

    public List<Course> getCourses() {
        return courses;
    }

}
