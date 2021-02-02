import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NgserviceService } from 'src/app/ngservice.service';
import { Customer } from '../customer';

@Component({
  selector: 'app-viewcustomers',
  templateUrl: './viewcustomers.component.html',
  styleUrls: ['./viewcustomers.component.css']
})
export class ViewcustomersComponent implements OnInit {

  customer=new Customer();
  constructor(private _route:Router,private _service:NgserviceService,private _activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    let id=parseInt(this._activatedRoute.snapshot.paramMap.get('id'));
    this._service.fetchCustomerByidFromRemote(id).subscribe(
      data=>{
        console.log("data recived");
        
        this.customer=data;
        console.log(this.customer);

      },
      error=>console.log("exception occured")
    )
  }
  
  gotolist(){
    console.log("go back");
    this._route.navigate(['customerlist']);
  }

}
