import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AboutusComponent } from './aboutus/aboutus.component';

import { AdminComponent } from './admin/admin.component';
import { ContactusComponent } from './contactus/contactus.component';
import { CustomerloginRegisterComponent } from './customerlogin-register/customerlogin-register.component';
import { VendorloginregisterComponent } from './vendorloginregister/vendorloginregister.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatTabsModule } from '@angular/material/tabs';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { ThankyouComponent } from './thankyou/thankyou.component';



@NgModule({
  declarations: [AboutusComponent,AdminComponent,ContactusComponent,CustomerloginRegisterComponent,
    VendorloginregisterComponent,DashboardComponent, HomeComponent, FooterComponent, ThankyouComponent],
  imports: [
    CommonModule,
    FormsModule,
    BrowserModule,
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
  ],exports:[AboutusComponent,AdminComponent,ContactusComponent,CustomerloginRegisterComponent,
    VendorloginregisterComponent,DashboardComponent,FooterComponent,ThankyouComponent,]
})
export class StandardModule { }
