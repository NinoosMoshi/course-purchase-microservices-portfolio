package com.ninos.apigatewaymicroservice3.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "course-service"   //Name of course-service application
            , path = "/api/course"          //Pre-path for course-service
            ,url = "${course.service.url}"  // in gateway application.properties  http://localhost:3333
            ,configuration = FeignConfiguration.class)
public interface CourseServiceRequest
{
    @PostMapping  // http://localhost:3333/api/course
    Object saveCourse(@RequestBody Object requestBody);

    @DeleteMapping("{courseId}")  // http://localhost:3333/api/course/{courseId}
    void deleteCourse(@PathVariable("courseId") Long courseId);

    @GetMapping   // http://localhost:3333/api/course
    List<Object> getAllCourses();
}
