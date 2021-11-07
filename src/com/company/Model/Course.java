package com.company.Model;

import java.util.LinkedList;
import java.util.List;

public class Course {
    private String name;
    private Person teacher;
    private int maxEnrollment;
    private List<Student> studentsEnrolled;
    private int credits;
    private long courseId;
    private static long courseIdCounter = 0;


    public Course(String name, Teacher teacher, int maxEnrollment, int credits){
        this.name = name;
        this.teacher = teacher;
        this.maxEnrollment = maxEnrollment;
        this.studentsEnrolled = new LinkedList<>();
        this.credits = credits;
        this.courseId = courseIdCounter;
        courseIdCounter++;
        teacher.addCourse(this);
    }


    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                ", maxEnrollment=" + maxEnrollment +
                ", nrEnrolledStudents=" + getNumberOfStudents() +
                ", credits=" + credits +
                ", courseId=" + courseId +
                '}';
    }

    public void addStudent(Student student) {
        studentsEnrolled.add(student);
    }

    public int getNumberOfStudents(){
        return studentsEnrolled.size();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public long getCourseId() {
        return courseId;
    }
}
