import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerloginRegisterComponent } from './customerlogin-register.component';

describe('CustomerloginRegisterComponent', () => {
  let component: CustomerloginRegisterComponent;
  let fixture: ComponentFixture<CustomerloginRegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerloginRegisterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerloginRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
