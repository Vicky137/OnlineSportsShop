import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgserviceService } from 'src/app/ngservice.service';
import { Admin } from 'src/app/standard/admin';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  admin = new Admin();
  msg;

  constructor(private _service:NgserviceService,private _router:Router) { }   
  

  ngOnInit(): void {
  }


  adminLogin(){
   
    this._service.loginAdmin(this.admin).subscribe(
      responseData =>
      {
      window.localStorage.setItem("admin", responseData.name);
      console.log("response recived");
      this._router.navigate(["/dashboard"]);
    },
    error =>{
      console.log("exception occured");
      this.msg="Bad credentials,Please enter valid email and password";
    }

    )
  }

}
