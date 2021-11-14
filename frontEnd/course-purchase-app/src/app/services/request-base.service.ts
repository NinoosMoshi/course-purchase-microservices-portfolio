import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';
import { User } from './../model/user';

export abstract class RequestBaseService {

  protected currentUser: User = new User;

  protected constructor(protected authenticationService:AuthenticationService, protected http: HttpClient) {
    this.authenticationService.currentUser.subscribe(data =>{
      this.currentUser = data
    });
  }

  get getHeader(): HttpHeaders{
    return new HttpHeaders({
      authorization: 'Bearer ' + this.currentUser?.token,
      "Content-Type": "application/json; charset=UTF-8"
    });
  }

}
