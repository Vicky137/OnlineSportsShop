import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorloginregisterComponent } from './vendorloginregister.component';

describe('VendorloginregisterComponent', () => {
  let component: VendorloginregisterComponent;
  let fixture: ComponentFixture<VendorloginregisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VendorloginregisterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VendorloginregisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
