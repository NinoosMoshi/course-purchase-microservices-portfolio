package com.ninos.coursemicroservice1.repository;

import com.ninos.coursemicroservice1.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
