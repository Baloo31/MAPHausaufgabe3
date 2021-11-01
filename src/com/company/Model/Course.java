package com.company.Model;

import java.util.List;

public class Course {
    private String name;
    private Person teacher;
    private int maxEnrollment;
    private List<Student> studentsEnrolled;
    private int credits;
    private long courseId;

    private static long courseIdCounter = 0;

    public Course(String name, Person teacher, int maxEnrollment, int credits){
        this.name = name;
        this.teacher = teacher;
        this.maxEnrollment = maxEnrollment;
        this.studentsEnrolled = List.of();
        this.credits = credits;
        this.courseId = courseIdCounter;
        courseIdCounter++;
    }

    public void addStudent(Student student) {
        studentsEnrolled.add(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacherId(Person teacher) {
        this.teacher = teacher;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public int getNumberOfStudents(){
        return studentsEnrolled.size();
    }

    public long getCourseId() {
        return courseId;
    }
}
