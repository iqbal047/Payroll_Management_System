import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PayrollTransactionListComponent } from './payroll-transaction-list.component';

describe('PayrollTransactionListComponent', () => {
  let component: PayrollTransactionListComponent;
  let fixture: ComponentFixture<PayrollTransactionListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PayrollTransactionListComponent]
    });
    fixture = TestBed.createComponent(PayrollTransactionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
