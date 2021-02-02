import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorproductlistComponent } from './vendorproductlist.component';

describe('VendorproductlistComponent', () => {
  let component: VendorproductlistComponent;
  let fixture: ComponentFixture<VendorproductlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VendorproductlistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VendorproductlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
