import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private _route:Router) { }

  ngOnInit(): void {
    
  }

  goToProductList(){
    console.log("product list");
    this._route.navigate(['/productlist']);
  }
  goToVendorList(){
    console.log("vendor list");
    this._route.navigate(['/vendorlist']);
  }

  goToCustomerList(){
    console.log("customer list");
    this._route.navigate(['/customerlist']);
  }

  gotolist(){
    console.log("go back");
    this._route.navigate(['']);
  }

}
