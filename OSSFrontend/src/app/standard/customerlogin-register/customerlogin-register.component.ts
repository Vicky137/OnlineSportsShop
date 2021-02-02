import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/customer/customer';
import { NgserviceService } from 'src/app/ngservice.service';

@Component({
  selector: 'app-customerlogin-register',
  templateUrl: './customerlogin-register.component.html',
  styleUrls: ['./customerlogin-register.component.css']
})
export class CustomerloginRegisterComponent implements OnInit {

  alert:boolean=false
  customer=new Customer();
  msg='';
  
    constructor(private _service : NgserviceService,private _router : Router) { }
  
   
    ngOnInit(): void {
    }
  
    loginCustomer(){
      this._service.loginCustomerFromRemote(this.customer).subscribe(
      data =>{console.log("respose received");
      this._router.navigate(["/customerview"]);
    },
      error =>{
        console.log("exception occured");
        this.msg="Bad credentials,Please enter valid email and password";
      }
      )
    }
    registerCustomer(){
      this._service.registerCustomerFromRemote(this.customer).subscribe(
        data=>{
          console.log("response received");
          this._router.navigate(["/customerview"]);
          this.alert=true
        },
        error=>{
          console.log("exception occured");
          this.msg=error.error;
        }
      )
      console.log(this.customer);
      this.alert=true
    }
  

}
