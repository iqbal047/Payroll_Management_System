import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaxWithHoldingListComponent } from './tax-with-holding-list.component';

describe('TaxWithHoldingListComponent', () => {
  let component: TaxWithHoldingListComponent;
  let fixture: ComponentFixture<TaxWithHoldingListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TaxWithHoldingListComponent]
    });
    fixture = TestBed.createComponent(TaxWithHoldingListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
