import { identifierModuleUrl } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { EmailValidator } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NgserviceService } from 'src/app/ngservice.service';
import { Vendor } from 'src/app/vendor/vendor';

@Component({
  selector: 'app-vendorloginregister',
  templateUrl: './vendorloginregister.component.html',
  styleUrls: ['./vendorloginregister.component.css']
})
export class VendorloginregisterComponent implements OnInit {

  alert:boolean=false
  vendor=new Vendor();
  msg='';
  data:any;
    constructor(private _service : NgserviceService,private _router : Router,private _activatedRoute:ActivatedRoute) { }
  
   
    ngOnInit(): void {
    }
  
    loginVendor(){

      //let id=parseInt(this._activatedRoute.snapshot.paramMap.get('id'));
      //console.log(id);
      //sessionStorage.setItem("vendor", JSON.stringify(data:))
    //   this._service.loginVendorFromRemote(this.vendor).subscribe(
    //   data =>{console.log("respose received");
    //   console.log(this.vendor);
    //   //console.log(this.data);
    //   this._router.navigate(["/vendordashboard"]);
    // }
    this._service.loginVendorFromRemote(this.vendor).subscribe(
      responseData =>
      {
      window.localStorage.setItem("vendor", responseData.name);
      console.log("response recived");
      console.log(this.vendor.email);
      this._router.navigate(["/productlist/"]);
    },
      error =>{
        console.log("exception occured");
        this.msg="Bad credentials,Please enter valid email and password";
      }
      )
    }
    registerVendor(){
      this.data={
        "vendorName": this.vendor.vendorName,
        "email": this.vendor.email,
        "password": this.vendor.password,
        "contactNumber": this.vendor.contactNumber,
        "storeName": this.vendor.storeName
     }

      this._service.registerVendorFromRemote(this.data).subscribe(
        data=>{
          console.log("responce received");
          this._router.navigate(["/catlog"]);
          this.alert=true
        },
        error=>{
          console.log("exception occured");
          this.msg=error.error;
        }
      )
      console.log(this.vendor);
      this.alert=true
    }
  

}
