package com.company.Model;

import java.util.LinkedList;
import java.util.List;

public class Student extends Person {
    private long studentId;
    private int totalCredits;
    private List<Course> enrolledCourses;

    private static long studentIdCounter = 0;

    public Student(String firstname, String lastName) {
        super(firstname, lastName);
        this.totalCredits = 0;
        this.enrolledCourses = new LinkedList<>();
        this.studentId = studentIdCounter;
        studentIdCounter++;
    }


    @Override
    public String toString() {
        return "Student{" +
                "firstName=" + getFirstName() +
                ", lastName=" + getLastName() +
                ", studentId=" + studentId +
                ", totalCredits=" + totalCredits +
                ", nrEnrolledCourses=" + getNumberOfCourses() +
                '}';
    }

    public void addCourse(Course course){
        this.totalCredits += course.getCredits();
        this.enrolledCourses.add(course);
    }

    public void deleteCourse(Course course){
        this.enrolledCourses.remove(course);
        this.totalCredits -= course.getCredits();
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

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

}
