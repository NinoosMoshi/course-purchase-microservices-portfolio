import { Router } from '@angular/router';
import { AuthenticationService } from './services/authentication.service';
import { User } from './model/user';
import { Component } from '@angular/core';
import { Role } from './model/role';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'course-purchase-app';

  currentUser: User = new User;

  constructor(private authenticationService: AuthenticationService, private router: Router){
     this.authenticationService.currentUser.subscribe(data =>{
       this.currentUser = data;
     })
  }

  isAdmin(){
    return this.currentUser?.role === Role.ADMIN;
  }

  logOut(){
     this.authenticationService.logOut();
     this.router.navigateByUrl("/login");
  }

}
