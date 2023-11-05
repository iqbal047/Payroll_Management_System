import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalaryFormComponent } from './salary-form.component';

describe('SalaryFormComponent', () => {
  let component: SalaryFormComponent;
  let fixture: ComponentFixture<SalaryFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SalaryFormComponent]
    });
    fixture = TestBed.createComponent(SalaryFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
