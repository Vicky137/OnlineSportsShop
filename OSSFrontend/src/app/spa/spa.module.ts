import { NgModule,CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomepageComponent } from './homepage/homepage.component';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { StandardModule } from '../standard/standard.module';
import { RouterModule, Routes } from '@angular/router';
import { AboutusComponent } from '../standard/aboutus/aboutus.component';
import { AdminComponent } from '../standard/admin/admin.component';
import { DashboardComponent } from '../standard/dashboard/dashboard.component';
import { ContactusComponent } from '../standard/contactus/contactus.component';
import { CustomerloginRegisterComponent } from '../standard/customerlogin-register/customerlogin-register.component';
import { VendorloginregisterComponent } from '../standard/vendorloginregister/vendorloginregister.component';
import { CustomerviewComponent } from '../product/customerview/customerview.component';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatTabsModule } from '@angular/material/tabs';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

const routes: Routes=[
  {path:'',redirectTo:'home',pathMatch:'full'},
  {path:'aboutus',component:AboutusComponent},
  {path:'adminlogin',component:AdminComponent},
   {path:'dashboard',component:DashboardComponent},
   {path:'customerview',component:CustomerviewComponent},
  {path:'customerlogin',component:CustomerloginRegisterComponent},
  {path:'vendorlogin',component:VendorloginregisterComponent},
  {path:'contactus',component:ContactusComponent},

];


@NgModule({
  declarations: [HomepageComponent],
  imports: [
    CommonModule,
    FormsModule,
    BrowserModule,StandardModule,
    MatToolbarModule,
    MatButtonModule,
    BrowserAnimationsModule,
    BrowserAnimationsModule,
    BrowserAnimationsModule,
    MatInputModule,
    RouterModule.forRoot(routes),
    MatCardModule,
    MatTabsModule,
    MatFormFieldModule,    
    MatButtonModule,
    MatCheckboxModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    StandardModule,
    
    MatToolbarModule,
  ],
  exports:[HomepageComponent
  ],
})
export class SpaModule { }
