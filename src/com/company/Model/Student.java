package com.company.Model;

import java.util.List;

public class Student extends Person {
    private long studentId;
    private int totalCredits;
    private List<Course> enrolledCourses;

    private static long studentIdCounter = 0;

    public Student(String firstname, String lastName) {
        super(firstname, lastName);
        this.studentId = studentIdCounter;
        studentIdCounter++;
        this.totalCredits = 0;
        this.enrolledCourses = List.of();
    }

    public void addCourse(Course course){
        this.totalCredits += course.getCredits();
        this.enrolledCourses.add(course);
    }

    public long getStudentId() {
        return studentId;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public int getNumberOfCourses(){
        return enrolledCourses.size();
    }
}
