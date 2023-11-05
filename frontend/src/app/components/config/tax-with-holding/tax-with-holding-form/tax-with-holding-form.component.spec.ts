import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaxWithHoldingFormComponent } from './tax-with-holding-form.component';

describe('TaxWithHoldingFormComponent', () => {
  let component: TaxWithHoldingFormComponent;
  let fixture: ComponentFixture<TaxWithHoldingFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TaxWithHoldingFormComponent]
    });
    fixture = TestBed.createComponent(TaxWithHoldingFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
