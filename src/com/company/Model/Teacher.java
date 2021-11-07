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
                "firstName=" + getFirstName() +
                ", lastName=" + getLastName() +
                ", teacherId=" + teacherId +
                ", nrOfCourses=" + getNrOfCourses() +
                '}';
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public int getNrOfCourses() {
        return courses.size();
    }

    public long getTeacherId() {
        return teacherId;
    }

    public List<Course> getCourses() {
        return courses;
    }

}
