package com.ninos.coursemicroservice1.service;

import com.ninos.coursemicroservice1.model.Course;

import java.util.List;

public interface CourseService {

    public Course saveCourse(Course course);

    public void deleteCourse(Long courseId);

    public List<Course> findAllCourses();


}
