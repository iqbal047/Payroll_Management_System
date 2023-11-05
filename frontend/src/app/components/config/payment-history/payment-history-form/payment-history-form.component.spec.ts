import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentHistoryFormComponent } from './payment-history-form.component';

describe('PaymentHistoryFormComponent', () => {
  let component: PaymentHistoryFormComponent;
  let fixture: ComponentFixture<PaymentHistoryFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PaymentHistoryFormComponent]
    });
    fixture = TestBed.createComponent(PaymentHistoryFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
