import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ViewvendorComponent } from './viewvendor/viewvendor.component';

import { VendorlistComponent } from './vendorlist/vendorlist.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { VendorproductlistComponent } from './vendorproductlist/vendorproductlist.component';
import { VendordashboardComponent } from './vendordashboard/vendordashboard.component';



@NgModule({
  declarations: [ViewvendorComponent, VendorlistComponent,FormsModule, VendorproductlistComponent, VendordashboardComponent],
  imports: [
    BrowserModule,
    CommonModule,FormsModule,ReactiveFormsModule
  ],
  exports:[VendorlistComponent,ViewvendorComponent,VendorproductlistComponent,VendordashboardComponent]
})
export class VendorModule { }
