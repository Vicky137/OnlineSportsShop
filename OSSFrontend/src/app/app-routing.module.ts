import { componentFactoryName } from '@angular/compiler';
import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerlistComponent } from './customer/customerlist/customerlist.component';
import { ViewcustomersComponent } from './customer/viewcustomers/viewcustomers.component';
import { AddproductComponent } from './product/addproduct/addproduct.component';
import { CustomerviewComponent } from './product/customerview/customerview.component';
import { EditproductComponent } from './product/editproduct/editproduct.component';
import { ProductlistComponent } from './product/productlist/productlist.component';
import { ViewcartComponent } from './product/viewcart/viewcart.component';
import { ViewproductComponent } from './product/viewproduct/viewproduct.component';


import { HomepageComponent } from './spa/homepage/homepage.component';
import { HomeComponent } from './standard/home/home.component';
import { ThankyouComponent } from './standard/thankyou/thankyou.component';
import { VendordashboardComponent } from './vendor/vendordashboard/vendordashboard.component';


import { VendorlistComponent } from './vendor/vendorlist/vendorlist.component';
import { VendorproductlistComponent } from './vendor/vendorproductlist/vendorproductlist.component';
import { ViewvendorComponent } from './vendor/viewvendor/viewvendor.component';

const routes: Routes = [
  
 
  {path:'productlist',component:ProductlistComponent},
  {path:'addproduct',component:AddproductComponent},
  {path:'editproduct',component:EditproductComponent},
  {path:'editproduct/:id',component:EditproductComponent},
  {path:'viewproduct',component:ViewproductComponent},
  {path:'viewproduct/:id',component:ViewproductComponent},
  {path:'vendorlist',component:VendorlistComponent},
  {path:'viewvendor',component:ViewvendorComponent},
  {path:'viewvendor/:vendorId',component:ViewvendorComponent},
  {path:'home',component:HomeComponent},  
  {path:'customerlist',component:CustomerlistComponent},
  {path:'viewcustomer/:id',component:ViewcustomersComponent},
  {path:'thankyou',component:ThankyouComponent},
  {path:'vendorproductlist', component:VendorproductlistComponent},
  {path:'vendorproductlist/:id', component:VendorproductlistComponent},
 
  {path:'viewcart', component:ViewcartComponent},
  {path:'vendordashboard',component:VendordashboardComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
