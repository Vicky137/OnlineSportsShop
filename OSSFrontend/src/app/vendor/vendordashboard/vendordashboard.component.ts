import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vendordashboard',
  templateUrl: './vendordashboard.component.html',
  styleUrls: ['./vendordashboard.component.css']
})
export class VendordashboardComponent implements OnInit {

  constructor(private _route:Router) { }

  ngOnInit(): void {
  }
  
  goToVendorProductList(){
    console.log("product list");
    this._route.navigate(['/vendorproductlist/']);
  }

  gotolist(){
    console.log("go back");
    this._route.navigate(['']);
  }
}
