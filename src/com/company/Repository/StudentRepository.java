package com.company.Repository;

import com.company.Model.Student;

/**
 * StudentRepository : extends in-memory repository
 */
public class StudentRepository extends InMemoryRepository<Student>{


    /**
     * constructor for a student repository
     */
    public StudentRepository(){
        super();
    }


    /**
     * updates a student
     * @param obj : student to update
     * @return updated student (Student)
     */
    @Override
    public Student update(Student obj) {
        Student studentToUpdate = this.repoList.stream()
                .filter(student -> student.getStudentId() == obj.getStudentId())
                .findFirst()
                .orElseThrow();

        studentToUpdate.setFirstName(obj.getFirstName());
        studentToUpdate.setLastName(obj.getLastName());
        return studentToUpdate;
    }
}
