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
        courseRepository.create(new Course("BD", teacherOne, 100, 6));
        courseRepository.create(new Course("OOP", teacherTwo, 2, 7));

        registrationSystem = new RegistrationSystem(courseRepository, studentRepository, teacherRepository);

    }

    @Test
    void register() {
    }

    @Test
    void retrieveCoursesWithFreePlaces() {
    }

    @Test
    void retrieveStudentsEnrolledForACourse() {
    }

    @Test
    void getAllCourses() {
        Assertions.assertEquals(2, registrationSystem.getAllCourses().size());
    }

    @Test
    void deleteCourse() {
    }
}