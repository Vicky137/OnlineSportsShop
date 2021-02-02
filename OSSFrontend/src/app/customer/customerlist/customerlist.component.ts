import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgserviceService } from 'src/app/ngservice.service';

import { Customer } from '../customer';

@Component({
  selector: 'app-customerlist',
  templateUrl: './customerlist.component.html',
  styleUrls: ['./customerlist.component.css']
})
export class CustomerlistComponent implements OnInit {

  
_customerslist: Customer[];

constructor(private _service:NgserviceService,private _route:Router) { }

ngOnInit(): void {

  this._service.getCustomerListFromRemote().subscribe(
    data=>{
      console.log("response recived");
      this._customerslist=data as Customer[];
      console.log(this._customerslist);
    },
    error=>console.log("exception occured")
    
  )
}

gotolist(){
  console.log("go back");
  this._route.navigate(['/dashboard']);
}

goToViewCustomer(id:number){
  console.log("id"+id);
  this._route.navigate(['/viewcustomer',id]);
}

deleteCustomer(id:number){
  this._service.deleteCustomerByidFromRemote(id).subscribe(
    data=>{console.debug("deleted successfully");
    this._route.navigate(['/customerlist']);
  },

  error=>console.log("exception occured")
  )
}
}