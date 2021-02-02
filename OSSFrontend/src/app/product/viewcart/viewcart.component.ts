import { Component, OnInit } from '@angular/core';
import { Product } from '../product';

@Component({
  selector: 'app-viewcart',
  templateUrl: './viewcart.component.html',
  styleUrls: ['./viewcart.component.css']
})
export class ViewcartComponent implements OnInit {
  cartArray:Product[]=[];
  productId:number;
  data:JSON;
  constructor() { }

  ngOnInit(): void {
    this.getSelectedProduct();
  }

  getSelectedProduct(){
    this.cartArray=JSON.parse(sessionStorage.getItem('shoppingCart'));
    console.log(JSON.parse(sessionStorage.getItem('shoppingCart')));
   
    console.log(this.cartArray);
    

  }

}
