import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerlistComponent } from './customerlist/customerlist.component';
import { ViewcustomersComponent } from './viewcustomers/viewcustomers.component';



@NgModule({
  declarations: [CustomerlistComponent, ViewcustomersComponent],
  imports: [
    CommonModule
  ],exports:[CustomerlistComponent,ViewcustomersComponent]
})
export class CustomerModule { }
