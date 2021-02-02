import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NgserviceService } from 'src/app/ngservice.service';
import { Vendor } from '../vendor';

@Component({
  selector: 'app-viewvendor',
  templateUrl: './viewvendor.component.html',
  styleUrls: ['./viewvendor.component.css']
})
export class ViewvendorComponent implements OnInit {

  vendor=new Vendor();
  constructor(private _route:Router,private _service:NgserviceService,private _activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    let vendorId=parseInt(this._activatedRoute.snapshot.paramMap.get('vendorId'));
    console.log(vendorId);
    this._service.fetchVendorByidFromRemote(vendorId).subscribe(
      data=>{
        console.log("data recived");
        
        this.vendor=data;
        console.log(this.vendor);

      },
      error=>console.log("exception occured")
    )
  }
  
  gotolist(){
    console.log("go back");
    this._route.navigate(['vendorlist']);
  }



}
