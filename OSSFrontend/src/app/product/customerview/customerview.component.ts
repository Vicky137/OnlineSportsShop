import { Component, OnInit } from '@angular/core';
import { NgserviceService } from 'src/app/ngservice.service';
import { Product } from '../product';

@Component({
  selector: 'app-customerview',
  templateUrl: './customerview.component.html',
  styleUrls: ['./customerview.component.css']
})
export class CustomerviewComponent implements OnInit {

  products:Product[];
  cartProduct:Product;
  cartArray:Product[]=[];

  constructor(private service:NgserviceService) { }

  ngOnInit(): void {
    this.getProductList();
  }
  getProductList() {
    this.service.getProductListFromRemote().subscribe(
      data=>{
        this.products=data as Product[];
        console.log("Data Received");
      },error=>{
        console.log("data receiver fails..!!");
      }
    );
  }

  shoppingCart:number[]=[];

  AddToCart(prodId)
  {
    //console.log("shopping cart id "+prodId);
    //sessionStorage.setItem('shoppingCart', JSON.stringify({productId:prodId}));
    this.service.fetchProductByidFromRemote(prodId).subscribe(
      data=>{
        this.cartProduct= data as Product;
        this.cartArray.push(this.cartProduct);
        sessionStorage.setItem('shoppingCart', JSON.stringify({array :this.cartArray}));
        alert("Product Added Successfully..!!")
        
      },error=>console.log("Failed to add data into shopping cart")
    );
    //this.cartArray.push(this.cartProduct);
  }

}
