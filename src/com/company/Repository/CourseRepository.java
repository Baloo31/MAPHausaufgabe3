package com.company.Repository;

import com.company.Model.Course;

/**
 * CourseRepository : extends in-memory repository
 */
public class CourseRepository extends InMemoryRepository<Course>{


    /**
     * constructor for a course repository
     */
    public CourseRepository(){
        super();
    }


    /**
     * updates a course
     * @param obj : course to update
     * @return updated course (Course)
     */
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
