import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgserviceService } from 'src/app/ngservice.service';
import { Product } from 'src/app/product/product';
import { Vendor } from 'src/app/product/vendor';
import { VendorProduct } from '../vendorproduct';

@Component({
  selector: 'app-vendorproductlist',
  templateUrl: './vendorproductlist.component.html',
  styleUrls: ['./vendorproductlist.component.css']
})
export class VendorproductlistComponent implements OnInit {

  _vendorproductslist: VendorProduct[];
 

  vendor= new Vendor();
  data:any;

  constructor(private _service:NgserviceService,private _route:Router,private _activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.data={
     
      "email": this.vendor.email
      
    }
    let id=parseInt(this._activatedRoute.snapshot.paramMap.get('email'));
    console.log(id);
    this._service.fetchVendorProductByEmailFromRemote(this.data.email).subscribe(
      data=>{
        console.log("response recived");
        this._vendorproductslist=data as VendorProduct[];
        console.log(this._vendorproductslist);
        console.log(this.data.email);
      },
      error=>console.log("exception occured")
      
    )
  }
  email(email: any) {
    throw new Error('Method not implemented.');
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
