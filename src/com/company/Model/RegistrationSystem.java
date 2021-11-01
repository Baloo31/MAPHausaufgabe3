package com.company.Model;

import com.company.Repository.CourseRepository;
import com.company.Repository.StudentRepository;
import com.company.Repository.TeacherRepository;

import java.util.LinkedList;
import java.util.List;

public class RegistrationSystem {
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    public RegistrationSystem(){
        this.courseRepository = new CourseRepository();
        this.studentRepository = new StudentRepository();
        this.teacherRepository = new TeacherRepository();
    }

    public boolean register(Course course, Student student){
        if ((course.getMaxEnrollment() == course.getNumberOfStudents()) ||
                (student.getTotalCredits() + course.getCredits() > 30)){
            return false;
        }
        course.addStudent(student);
        student.addCourse(course);
        return true;
    }

    public List<Course> retrieveCoursesWithFreePlaces(){
        List<Course> coursesWithFreePlaces = new LinkedList<>();
        for (Course course : courseRepository.getAll()){
            if (course.getMaxEnrollment() > course.getNumberOfStudents()){
                coursesWithFreePlaces.add(course);
            }
        }
        return coursesWithFreePlaces;
    }

    public List<Student> retrieveStudentsEnrolledForACourse(Course course){
        return course.getStudentsEnrolled();
    }

    public List<Course> getAllCourses(){
        return courseRepository.getAll();
    }

    public boolean deleteCourse(Teacher teacher, Course courseToDelete){
        if (courseToDelete.getTeacher() == teacher) {
            for (Student student :  courseToDelete.getStudentsEnrolled()){
                student.deleteCourse(courseToDelete);
            }
            courseRepository.delete(courseToDelete);
            return true;
        }
        return false;
    }

    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseRepository getCourseRepository() {
        return courseRepository;
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public TeacherRepository getTeacherRepository() {
        return teacherRepository;
    }
}
