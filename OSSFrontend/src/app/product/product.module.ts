import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddproductComponent } from './addproduct/addproduct.component';
import { ProductlistComponent } from './productlist/productlist.component';
import { EditproductComponent } from './editproduct/editproduct.component';
import { ViewproductComponent } from './viewproduct/viewproduct.component';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ShoppingcartComponent } from './shoppingcart/shoppingcart.component';
import { CustomerviewComponent } from './customerview/customerview.component';
import { ViewcartComponent } from './viewcart/viewcart.component';
import { StandardModule } from '../standard/standard.module';
import { FooterComponent } from '../standard/footer/footer.component';
import { ThankyouComponent } from '../standard/thankyou/thankyou.component';



@NgModule({
  declarations: [AddproductComponent, ProductlistComponent, EditproductComponent,FooterComponent, ViewproductComponent,FormsModule, ShoppingcartComponent, CustomerviewComponent, ViewcartComponent],
  imports: [
    BrowserModule,CommonModule,FormsModule,ReactiveFormsModule,StandardModule,ThankyouComponent],
  exports:[ProductlistComponent,AddproductComponent,EditproductComponent,ViewproductComponent,
    CustomerviewComponent,ViewcartComponent]
})

export class ProductModule { }
