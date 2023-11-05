import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimeOffListComponent } from './time-off-list.component';

describe('TimeOffListComponent', () => {
  let component: TimeOffListComponent;
  let fixture: ComponentFixture<TimeOffListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TimeOffListComponent]
    });
    fixture = TestBed.createComponent(TimeOffListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
