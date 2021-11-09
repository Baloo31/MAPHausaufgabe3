import com.company.Model.Course;
import com.company.Model.Student;
import com.company.Model.Teacher;
import com.company.Repository.CourseRepository;
import com.company.Repository.StudentRepository;
import com.company.Repository.TeacherRepository;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InMemoryRepositoryTest {

    @Test
    void testCreate(){
        StudentRepository studentRepository = new StudentRepository();
        Student studentOne = studentRepository.create(new Student("Andrei", "Balu"));
        Student studentTwo = studentRepository.create(new Student("Darius", "Bucur"));
        Student studentThree = studentRepository.create(new Student("Adrian", "Goga"));
        Assertions.assertEquals(3,studentRepository.getAll().size());

        TeacherRepository teacherRepository = new TeacherRepository();
        Teacher teacherOne = teacherRepository.create(new Teacher("Vlad", "Zamfir"));
        Teacher teacherTwo = teacherRepository.create(new Teacher("Radu", "Ioan"));
        Teacher teacherThree = teacherRepository.create(new Teacher("Anca", "Muresan"));
        Assertions.assertEquals(3, teacherRepository.getAll().size());

        CourseRepository courseRepository = new CourseRepository();
        courseRepository.create(new Course("BD", teacherOne, 100, 6));
        courseRepository.create(new Course("OOP", teacherTwo, 2, 7));
        Assertions.assertEquals(2,courseRepository.getAll().size());
    }

    @Test
    void testUpdate(){
        StudentRepository studentRepository = new StudentRepository();
        Student student = studentRepository.create(new Student("Andrei", "Balu"));
        student.setLastName("Ioan");
        student = studentRepository.update(student);
        Assertions.assertEquals(student.getLastName(), studentRepository.getAll().get(0).getLastName());

        TeacherRepository teacherRepository = new TeacherRepository();
        Teacher teacher = teacherRepository.create(new Teacher("Vlad", "Zamfir"));
        teacher.setFirstName("Andrei");
        teacher = teacherRepository.update(teacher);
        Assertions.assertEquals(teacher.getFirstName(), teacherRepository.getAll().get(0).getFirstName());

        CourseRepository courseRepository = new CourseRepository();
        Course course = courseRepository.create(new Course("BD", teacher, 100, 6));
        course.setCredits(5);
        course = courseRepository.update(course);
        Assertions.assertEquals(5, course.getCredits());
        Assertions.assertEquals(5, courseRepository.getAll().get(0).getCredits());
    }

    @Test
    void testDelete(){
        StudentRepository studentRepository = new StudentRepository();
        Student studentToDelete = studentRepository.create(new Student("Andrei", "Balu"));
        Student studentOne = studentRepository.create(new Student("Darius", "Bucur"));
        Student studentTwo = studentRepository.create(new Student("Adrian", "Goga"));
        Assertions.assertEquals(3, studentRepository.getAll().size());
        studentRepository.delete(studentToDelete);
        Assertions.assertEquals(2, studentRepository.getAll().size());
        Assertions.assertEquals(studentOne.getStudentId(), studentRepository.getAll().get(0).getStudentId());
        Assertions.assertEquals(studentTwo.getStudentId(), studentRepository.getAll().get(1).getStudentId());

        TeacherRepository teacherRepository = new TeacherRepository();
        Teacher teacherToDelete = teacherRepository.create(new Teacher("Vlad", "Zamfir"));
        teacherRepository.delete(teacherToDelete);
        Assertions.assertTrue(teacherRepository.getAll().isEmpty());

        CourseRepository courseRepository = new CourseRepository();
        Course courseToDelete = courseRepository.create(new Course("BD", teacherToDelete, 1, 6));
        courseRepository.delete(courseToDelete);
        Assertions.assertTrue(courseRepository.getAll().isEmpty());
    }
}