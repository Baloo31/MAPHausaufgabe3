package com.company;

import com.company.Model.Course;
import com.company.Model.Person;
import com.company.Model.Student;
import com.company.Model.Teacher;
import com.company.Repository.CourseRepository;
import com.company.Repository.StudentRepository;
import com.company.Repository.TeacherRepository;

public class Main {

    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.create(new Student("Andrei", "Balu"));
        studentRepository.create(new Student("Darius", "Bucur"));
        studentRepository.create(new Student("Adrian", "Goga"));

        for (Student stud : studentRepository.getAll()){
            System.out.println(stud);
        }

        TeacherRepository teacherRepository = new TeacherRepository();
        Teacher teacher1 = new Teacher("Vlad", "Zamfir");
        teacherRepository.create(teacher1);
        teacherRepository.create(new Teacher("Radu", "Ioan"));
        teacherRepository.create(new Teacher("Anca", "Muresan"));


        CourseRepository courseRepository = new CourseRepository();
        courseRepository.create(new Course("BD", teacher1, 100, 6));
        courseRepository.create(new Course("OOP", teacher1, 60, 7));

        for (Teacher teacher : teacherRepository.getAll()){
            System.out.println(teacher);
        }

        for (Course course : courseRepository.getAll()){
            System.out.println(course);
        }
    }
}
