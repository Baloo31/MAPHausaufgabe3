package com.company.Repository;

import com.company.Model.Teacher;

public class TeacherRepository extends InMemoryRepository<Teacher>{

    public TeacherRepository(){
        super();
    }

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