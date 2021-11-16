import { CourseService } from './../../services/course.service';
import { Course } from './../../model/course';
import { Component, OnInit } from '@angular/core';

declare var $:any;

@Component({
  selector: 'app-course-save',
  templateUrl: './course-save.component.html',
  styleUrls: ['./course-save.component.css']
})
export class CourseSaveComponent implements OnInit {

  course: Course = new Course();
  errorMessage: string = "";

  constructor(private courseService: CourseService) { }

  ngOnInit(): void {
  }

  saveCourse() {
    this.courseService.saveCourse(this.course).subscribe(data => {

      $('#courseModal').modal('hide');

    }, err => {
      this.errorMessage = 'Unexpected error occurred.';
      console.log(err);
    });
  }


   showCourseModal(){
     $('#courseModal').modal('show');
   }



}
