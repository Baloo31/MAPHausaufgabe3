package com.company.Repository;

import com.company.Model.Course;

public class CourseRepository extends InMemoryRepository<Course>{

    public CourseRepository(){
        super();
    }

    @Override
    public Course update(Course obj) {
        Course courseToUpdate = this.repoList.stream()
                .filter(course -> course.getCourseId() == obj.getCourseId())
                .findFirst()
                .orElseThrow();

        courseToUpdate.setName(obj.getName());
        courseToUpdate.setMaxEnrollment(obj.getMaxEnrollment());
        courseToUpdate.setCredits(obj.getCredits());
        courseToUpdate.setTeacher(obj.getTeacher());
        return courseToUpdate;
    }
}
