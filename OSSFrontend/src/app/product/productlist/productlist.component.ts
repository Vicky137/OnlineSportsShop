import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { NgserviceService } from 'src/app/ngservice.service';
import { Product } from '../product';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {

  _productslist: Product[];
  
  constructor(private _service:NgserviceService,private _route:Router) { }

  ngOnInit(): void {
    this._service.getProductListFromRemote().subscribe(
      data=>{
        console.log("response recived");
        this._productslist=data as Product[];
        console.log(this._productslist);
      },
      error=>console.log("exception occured")
      
    )
  }

  goToAddProduct(){
    this._route.navigate(['/addproduct']);
  }

  goToEditProduct(id:number){
   console.log("id"+id);
    this._route.navigate(['/editproduct',id]);
  }

  goToViewProduct(id:number){
    console.log("id"+id);
    this._route.navigate(['/viewproduct',id]);
  }

  deleteProduct(id:number){
    this._service.deleteProductByidFromRemote(id).subscribe(
      data=>{console.debug("deleted successfully");
      this._route.navigate(['/productlist']);
    },
  
    error=>console.log("exception occured")
    )
  }


  gotolist(){
    console.log("go back");
    this._route.navigate(['/dashboard']);
  }









}
