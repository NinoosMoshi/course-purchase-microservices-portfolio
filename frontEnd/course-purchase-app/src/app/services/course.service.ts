import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Course } from '../model/course';
import { AuthenticationService } from './authentication.service';
import { RequestBaseService } from './request-base.service';


const API_URL = environment.BASE_URL + '/gateway/course';

@Injectable({
  providedIn: 'root'
})
export class CourseService extends RequestBaseService {

  constructor(authenticationService: AuthenticationService, http: HttpClient) {
    super(authenticationService, http);
  }

  saveCourse(course: Course): Observable<any> {
    return this.http.post(API_URL, course, {headers: this.getHeaders});
  }

  deleteCourse(course: Course): Observable<any> {
    return this.http.delete(API_URL + '/' + course.id, {headers: this.getHeaders});
  }

  getAllCourses(): Observable<any> {
    return this.http.get(API_URL);
  }
}
