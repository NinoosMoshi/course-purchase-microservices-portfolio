package com.ninos.coursemicroservice1.service;

import com.ninos.coursemicroservice1.model.Course;
import com.ninos.coursemicroservice1.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long courseId) {
       courseRepository.deleteById(courseId);
    }

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }
}
