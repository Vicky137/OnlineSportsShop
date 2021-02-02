import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from './customer/customer';
import { Product } from './product/product';
import { ProductlistComponent } from './product/productlist/productlist.component';
import { Admin } from './standard/admin';
import { Vendor } from './vendor/vendor';

@Injectable({
  providedIn: 'root'
})
export class NgserviceService {
  data:any;
  constructor(private _http:HttpClient) { }

    getProductListFromRemote():Observable<any>{
        return this._http.get<any>("http://localhost:8080/product");
  }
  addProductToRemote(product : Product):Observable<any>{
    // this.data=
    //   {
    //     "description": product.description,
    //     "name": product.name,
    //     "quantity": product.quantity,
    //     "unitPrice": product.unitPrice,
    //     "imageUrl": product.imageUrl,
    //     "orderItemId": null,
    //     "categoryId": product.category.id,
    //     "vendorId": product.vendor.id
    //     } 
    

    return this._http.post<any>("http://localhost:8080/product",product);
  }

 
   updateProductFromRemote(id:number,product:Product):Observable<any>{
     return this._http.put<any>("http://localhost:8080/product/"+id,product);
   }
  fetchProductByidFromRemote(id : number):Observable<any>{
    return this._http.get<any>("http://localhost:8080/product/"+id);
  }

  deleteProductByidFromRemote(id : number):Observable<any>{
    return this._http.delete<any>("http://localhost:8080/product/"+id);
  }

  getVendorListFromRemote():Observable<any>{
    return this._http.get<any>("http://localhost:8080/vendor");
}

deleteVendorByidFromRemote(id : number):Observable<any>{
  return this._http.delete<any>("http://localhost:8080/vendor/"+id);
}

fetchVendorByidFromRemote(vendorId : number):Observable<any>{
  return this._http.get<any>("http://localhost:8080/vendor/"+vendorId);
}
 
 
  public loginAdmin(admin:Admin) : Observable<any>{
    return this._http.post<any>("http://localhost:8080/admin/login",admin);
  }

  public loginVendorFromRemote(vendor:Vendor) : Observable<any>{
    return this._http.post<any>("http://localhost:8080/vendor/login",vendor);
  }
  public registerVendorFromRemote(vendor:Vendor):Observable<any>{
    return this._http.post<any>("http://localhost:8080/vendor/register",vendor);
  }
  getCustomerListFromRemote():Observable<any>{
    return this._http.get<any>("http://localhost:8080/customer");
}

deleteCustomerByidFromRemote(id : number):Observable<any>{
  return this._http.delete<any>("http://localhost:8080/customer/"+id);
}

fetchCustomerByidFromRemote(id : number):Observable<any>{
  return this._http.get<any>("http://localhost:8080/customer/"+id);
}
 
public loginCustomerFromRemote(customer:Customer):Observable<any>{
  return this._http.post<any>("http://localhost:8080/customer/login",customer);
}

public registerCustomerFromRemote(customer:Customer):Observable<any>{
  return this._http.post<any>("http://localhost:8080/customer/register",customer);
}

 fetchVendorProductByEmailFromRemote(email:string):Observable<any>{
   return this._http.get<any>("http://localhost:8080/product/vendor/email/"+email);
 }

fetchVendorProductByIdFromRemote(id:number):Observable<any>{
  return this._http.get<any>("http://localhost:8080/product/vendor/"+id);
}
 

}
