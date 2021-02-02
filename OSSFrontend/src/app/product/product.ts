import { Vendor } from "./vendor";
import { Category } from "./category";

export class Product {
    public id:number;
    public name:string;
    public description:string;
    public unitPrice:number;
    public quantity:number;
    public imageUrl:string;
    // category :Category;
    // vendor :Vendor;
   categoryId:Category;
     vendorId:Vendor;
     categoryName:Category;
     vendorName:Vendor;
     brand:Category;
     vendorEmail:Vendor;
    constructor(){};
}
