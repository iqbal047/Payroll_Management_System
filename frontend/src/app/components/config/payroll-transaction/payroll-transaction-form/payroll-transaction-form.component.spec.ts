import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PayrollTransactionFormComponent } from './payroll-transaction-form.component';

describe('PayrollTransactionFormComponent', () => {
  let component: PayrollTransactionFormComponent;
  let fixture: ComponentFixture<PayrollTransactionFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PayrollTransactionFormComponent]
    });
    fixture = TestBed.createComponent(PayrollTransactionFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
