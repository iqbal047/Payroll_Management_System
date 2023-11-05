import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentHistoryListComponent } from './payment-history-list.component';

describe('PaymentHistoryListComponent', () => {
  let component: PaymentHistoryListComponent;
  let fixture: ComponentFixture<PaymentHistoryListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PaymentHistoryListComponent]
    });
    fixture = TestBed.createComponent(PaymentHistoryListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
