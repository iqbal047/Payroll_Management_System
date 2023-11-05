import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BenefitsFormComponent } from './benefits-form.component';

describe('BenefitsFormComponent', () => {
  let component: BenefitsFormComponent;
  let fixture: ComponentFixture<BenefitsFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BenefitsFormComponent]
    });
    fixture = TestBed.createComponent(BenefitsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
