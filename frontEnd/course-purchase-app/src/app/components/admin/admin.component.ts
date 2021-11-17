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
  selectedCourse: Course = new Course();

  @ViewChild(CourseSaveComponent) saveComponent: CourseSaveComponent | undefined;

  constructor(private courseService: CourseService) { }

  ngOnInit(): void {
    this.courseService.getAllCourses().subscribe(data =>{
      this.courseList = data;
    })
  }


  createCourseRequest(){
    this.selectedCourse = new Course();
    this.saveComponent?.showCourseModal();
  }


  editCourseRequest(item: Course){
     this.selectedCourse = Object.assign({}, item);
     this.saveComponent?.showCourseModal();
  }



  saveCourseWatcher(course: Course){
    let itemIndex = this.courseList.findIndex(item => item.id === course.id);

    if(itemIndex !== -1){  // if course item is exists
      this.courseList[itemIndex] = course;  // then it's edit
    }else{
      this.courseList.push(course);   // else it's create
    }

  }


}
