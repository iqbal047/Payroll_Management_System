import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BenefitsListComponent } from './benefits-list.component';

describe('BenefitsListComponent', () => {
  let component: BenefitsListComponent;
  let fixture: ComponentFixture<BenefitsListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BenefitsListComponent]
    });
    fixture = TestBed.createComponent(BenefitsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
