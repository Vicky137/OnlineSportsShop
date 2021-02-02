import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgserviceService } from 'src/app/ngservice.service';
import { Product } from '../product';

@Component({
  selector: 'app-editproduct',
  templateUrl: './editproduct.component.html',
  styleUrls: ['./editproduct.component.css']
})
export class EditproductComponent implements OnInit {
  product=new Product();
  constructor(private _route:Router,private _service:NgserviceService,private _activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    let id=parseInt(this._activatedRoute.snapshot.paramMap.get('id'));
    this._service.fetchProductByidFromRemote(id).subscribe(
      data=>{
        console.log("data recived");
        
        this.product=data as Product;
       
        console.log(this.product);

      },
      error=>console.log("exception occured")
    )
  }
  updateProductFormSubmit()
  {
    let id=parseInt(this._activatedRoute.snapshot.paramMap.get('id'));
    this._service.updateProductFromRemote(id, this.product).subscribe(
      data=>{
        console.log("data added successfully");
        alert("data update successfully");
        this._route.navigate(['productlist']);
      },
      error=>console.log("error occured")
    )
  }
  gotolist(){
    console.log("go back");
    this._route.navigate(['productlist']);
  }

}
