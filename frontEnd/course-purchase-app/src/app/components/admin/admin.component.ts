import { CourseSaveComponent } from './../course-save/course-save.component';
import { CourseService } from './../../services/course.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Course } from 'src/app/model/course';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  courseList: Array<Course> = [];

  @ViewChild(CourseSaveComponent) saveComponent: CourseSaveComponent | undefined;

  constructor(private courseService: CourseService) { }

  ngOnInit(): void {
    this.courseService.getAllCourses().subscribe(data =>{
      this.courseList = data;
    })
  }


  createCourseRequest(){
    this.saveComponent?.showCourseModal();
  }



  saveCourseWatcher(course: Course){
    this.courseList.push(course);
  }


}
