import com.company.Model.Course;
import com.company.Model.RegistrationSystem;
import com.company.Model.Student;
import com.company.Model.Teacher;
import com.company.Repository.CourseRepository;
import com.company.Repository.StudentRepository;
import com.company.Repository.TeacherRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class RegistrationSystemTest {
    RegistrationSystem registrationSystem;

    @BeforeEach
    void setUp() {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.create(new Student("Andrei", "Balu"));
        studentRepository.create(new Student("Darius", "Bucur"));
        studentRepository.create(new Student("Adrian", "Goga"));

        TeacherRepository teacherRepository = new TeacherRepository();
        Teacher teacherOne = teacherRepository.create(new Teacher("Vlad", "Zamfir"));
        Teacher teacherTwo = teacherRepository.create(new Teacher("Radu", "Ioan"));
        teacherRepository.create(new Teacher("Anca", "Muresan"));

        CourseRepository courseRepository = new CourseRepository();
        courseRepository.create(new Course("BD", teacherOne, 1, 6));
        courseRepository.create(new Course("OOP", teacherTwo, 2, 7));

        registrationSystem = new RegistrationSystem(courseRepository, studentRepository, teacherRepository);

    }

    @Test
    void register() {
        Student student = registrationSystem.getStudentRepo().getAll().get(0);
        List<Course> courses = registrationSystem.getAllCourses();
        registrationSystem.register(courses.get(0), student);
        registrationSystem.register(courses.get(1), student);
        Assertions.assertEquals(2,student.getNumberOfCourses());
        Assertions.assertEquals(13, student.getTotalCredits());
    }

    @Test
    void retrieveCoursesWithFreePlaces() {
        Student student = registrationSystem.getStudentRepo().getAll().get(0);
        List<Course> courses = registrationSystem.getAllCourses();
        registrationSystem.register(courses.get(0), student);
        List<Course> coursesWithFreePlaces = registrationSystem.retrieveCoursesWithFreePlaces();
        Assertions.assertEquals(courses.get(1), coursesWithFreePlaces.get(0));
    }

    @Test
    void retrieveStudentsEnrolledForACourse() {
        Student student = registrationSystem.getStudentRepo().getAll().get(0);
        List<Course> courses = registrationSystem.getAllCourses();
        registrationSystem.register(courses.get(0), student);
        registrationSystem.register(courses.get(1), student);
        List<Student> students = registrationSystem.retrieveStudentsEnrolledForACourse(courses.get(0));
        Assertions.assertEquals(student, students.get(0));
    }

    @Test
    void getAllCourses() {
        Assertions.assertEquals(2, registrationSystem.getAllCourses().size());
    }

    @Test
    void deleteCourse() {
        Student student = registrationSystem.getStudentRepo().getAll().get(0);
        List<Course> courses = registrationSystem.getAllCourses();
        registrationSystem.register(courses.get(0), student);
        registrationSystem.register(courses.get(1), student);
        Assertions.assertEquals(2,student.getNumberOfCourses());
        Assertions.assertEquals(13, student.getTotalCredits());
        Teacher teacher = registrationSystem.getTeacherRepo().getAll().get(0);
        registrationSystem.deleteCourse(teacher, courses.get(0));
        Assertions.assertEquals(1,student.getNumberOfCourses());
        Assertions.assertEquals(7, student.getTotalCredits());
        registrationSystem.deleteCourse(teacher, courses.get(0));
        Assertions.assertEquals(1,student.getNumberOfCourses());
        Assertions.assertEquals(7, student.getTotalCredits());
    }
}