import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Purchase } from 'src/app/model/purchase';
import { Role } from 'src/app/model/role';
import { User } from 'src/app/model/user';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { PurchaseService } from 'src/app/services/purchase.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  purchaseList: Array<Purchase> = [];
  errorMessage: string = "";
  currentUser: User = new User;

  constructor(private purchaseService: PurchaseService,
    private userService: UserService,
    private authenticationService: AuthenticationService,
    private router: Router) { }

  ngOnInit(): void {
    this.authenticationService.currentUser.subscribe(data => {
      this.currentUser = data;
    });

    this.purchaseService.getAllPurchaseItems().subscribe(data => {
      this.purchaseList = data;
    });
  }

  changeRole() {
    const newRole = this.currentUser.role === Role.ADMIN ? Role.USER : Role.ADMIN;  // if role is user then role will chant to admin and vice versa

    this.userService.changeRole(newRole).subscribe(() => {
      this.authenticationService.logOut();
      this.router.navigate(['/login']);
    }, error => {
      this.errorMessage = 'Unexpected error occurred.';
      console.log(error);
    })
  }

}
