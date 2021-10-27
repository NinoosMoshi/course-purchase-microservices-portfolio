package com.ninos.coursemicroservice1.controller;

import com.ninos.coursemicroservice1.model.Course;
import com.ninos.coursemicroservice1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping  // http://localhost:3333/api/course
    public ResponseEntity<?> saveCourse(@RequestBody Course course){
       Course course1= courseService.saveCourse(course);
        return new ResponseEntity<>(course1, CREATED);
    }

    @DeleteMapping("{courseId}") // http://localhost:3333/api/course/courseId
    public ResponseEntity<?> deleteCourse(@PathVariable Long courseId){
         courseService.deleteCourse(courseId);
         return new ResponseEntity<>(OK);
    }


    @GetMapping  // http://localhost:3333/api/course
    public ResponseEntity<?> getAllCourses(){
        List<Course> courses = courseService.findAllCourses();
        return ResponseEntity.ok(courses);
    }









}
