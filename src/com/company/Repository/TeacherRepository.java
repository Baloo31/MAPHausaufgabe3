package com.company.Repository;

import com.company.Model.Teacher;

/**
 * TeacherRepository : extends in-memory repository
 */
public class TeacherRepository extends InMemoryRepository<Teacher>{


    /**
     * constructor for a teacher repository
     */
    public TeacherRepository(){
        super();
    }


    /**
     * updates a teacher
     * @param obj : teacher to update
     * @return updated teacher (Teacher)
     */
    @Override
    public Teacher update(Teacher obj) {
        Teacher teacherToUpdate = this.repoList.stream()
                .filter(teacher -> teacher.getTeacherId() == obj.getTeacherId())
                .findFirst()
                .orElseThrow();

        teacherToUpdate.setFirstName(obj.getFirstName());
        teacherToUpdate.setLastName(obj.getLastName());
        return teacherToUpdate;
    }
}
