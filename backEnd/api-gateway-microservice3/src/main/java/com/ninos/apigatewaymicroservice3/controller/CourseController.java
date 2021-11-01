package com.ninos.apigatewaymicroservice3.controller;

import com.ninos.apigatewaymicroservice3.request.CourseServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gateway/course") //pre-path
public class CourseController
{
    @Autowired
    private CourseServiceRequest courseServiceRequest;

    @PostMapping // http://localhost:5555/gateway/course
    public ResponseEntity<?> saveCourse(@RequestBody Object course) {
        return new ResponseEntity<>(courseServiceRequest.saveCourse(course), HttpStatus.CREATED);
    }

    @DeleteMapping("{courseId}")// http://localhost:5555/gateway/course/{courseId}
    public ResponseEntity<?> deleteCourse(@PathVariable Long courseId) {
        courseServiceRequest.deleteCourse(courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping//http://localhost:5555/gateway/course
    public ResponseEntity<?> getAllCourses() {
        return ResponseEntity.ok(courseServiceRequest.getAllCourses());
    }
}