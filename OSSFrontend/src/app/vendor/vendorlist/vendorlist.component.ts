import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgserviceService } from 'src/app/ngservice.service';
import { Vendor } from '../vendor';

@Component({
  selector: 'app-vendorlist',
  templateUrl: './vendorlist.component.html',
  styleUrls: ['./vendorlist.component.css']
})
export class VendorlistComponent implements OnInit {
   _vendorslist: Vendor[];

  constructor(private _service:NgserviceService,private _route:Router) { }

  ngOnInit(): void {

    this._service.getVendorListFromRemote().subscribe(
      data=>{
        console.log("response recived");
        this._vendorslist=data as Vendor[];
        console.log(this._vendorslist);
      },
      error=>console.log("exception occured")
      
    )
  }

  gotolist(){
    console.log("go back");
    this._route.navigate(['/dashboard']);
  }

  goToViewVendor(id:number){
    console.log("id"+id);
    this._route.navigate(['/viewvendor',id]);
  }

  deleteVendor(id:number){
    this._service.deleteVendorByidFromRemote(id).subscribe(
      data=>{console.debug("deleted successfully");
      this._route.navigate(['/vendorlist']);
    },
  
    error=>console.log("exception occured")
    )
  }
  }


