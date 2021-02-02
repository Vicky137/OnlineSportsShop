import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { CommonModule } from '@angular/common';
import { ProductlistComponent } from './product/productlist/productlist.component';
import { AddproductComponent } from './product/addproduct/addproduct.component';
import { EditproductComponent } from './product/editproduct/editproduct.component';
import { ViewproductComponent } from './product/viewproduct/viewproduct.component';
import { VendorlistComponent } from './vendor/vendorlist/vendorlist.component';
import { ViewvendorComponent } from './vendor/viewvendor/viewvendor.component';
import { HomepageComponent } from './spa/homepage/homepage.component';

import { MatCardModule } from '@angular/material/card';
import { MatTabsModule } from '@angular/material/tabs';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCheckboxModule } from '@angular/material/checkbox';

import { MatIconModule } from '@angular/material/icon';


import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { CustomerlistComponent } from './customer/customerlist/customerlist.component';
import { ViewcustomersComponent } from './customer/viewcustomers/viewcustomers.component';



import { VendorproductlistComponent } from './vendor/vendorproductlist/vendorproductlist.component';
import { CustomerviewComponent } from './product/customerview/customerview.component';
import { ViewcartComponent } from './product/viewcart/viewcart.component';
import { VendordashboardComponent } from './vendor/vendordashboard/vendordashboard.component';
import { SpaModule } from './spa/spa.module';
import { FooterComponent } from './standard/footer/footer.component';
import { ThankyouComponent } from './standard/thankyou/thankyou.component';



@NgModule({
  declarations: [
    AppComponent,
    ProductlistComponent,
    AddproductComponent,
    EditproductComponent,
    ViewproductComponent,
    VendorlistComponent,
    ViewvendorComponent,
    CustomerlistComponent,
    ViewcustomersComponent,
    VendorproductlistComponent,
    CustomerviewComponent,
    ViewcartComponent,
    VendordashboardComponent,
      
    
    
  ],
  imports: [
    CommonModule,
    BrowserModule,
    FormsModule, 
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    MatToolbarModule,
    MatButtonModule,
    BrowserAnimationsModule,
    BrowserAnimationsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatCardModule,
    MatTabsModule,
    MatFormFieldModule,    
    MatButtonModule,
    MatCheckboxModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatToolbarModule,
    SpaModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
