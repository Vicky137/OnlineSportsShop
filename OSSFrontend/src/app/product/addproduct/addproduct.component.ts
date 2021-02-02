import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { Router } from '@angular/router';
import { NgserviceService } from 'src/app/ngservice.service';
import { Product } from '../product';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {

    product=new Product();
  newVal: any;
  constructor(private _route:Router,private _service:NgserviceService) { }

  ngOnInit(): void {
  }
 
  addProductFormSubmit()
  {
    this._service.addProductToRemote(this.product).subscribe(
      data=>{
        console.log("data added successfully");
        this._route.navigate(['/productlist']);
      },
      error=>console.log("error occured")
    )
  }
  gotolist(){
    console.log("go back");
    this._route.navigate(['productlist']);
  }
}

