import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimeOffFormComponent } from './time-off-form.component';

describe('TimeOffFormComponent', () => {
  let component: TimeOffFormComponent;
  let fixture: ComponentFixture<TimeOffFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TimeOffFormComponent]
    });
    fixture = TestBed.createComponent(TimeOffFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
