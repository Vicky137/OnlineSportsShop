import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NgserviceService } from 'src/app/ngservice.service';
import { Product } from '../product';

@Component({
  selector: 'app-viewproduct',
  templateUrl: './viewproduct.component.html',
  styleUrls: ['./viewproduct.component.css']
})
export class ViewproductComponent implements OnInit {

  product=new Product();
  constructor(private _route:Router,private _service:NgserviceService,private _activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    let id=parseInt(this._activatedRoute.snapshot.paramMap.get('id'));
    this._service.fetchProductByidFromRemote(id).subscribe(
      data=>{
        console.log("data recived");
        
        this.product=data;
        console.log(this.product);

      },
      error=>console.log("exception occured")
    )
  }
  
  gotolist(){
    console.log("go back");
    this._route.navigate(['productlist']);
  }


  

}
