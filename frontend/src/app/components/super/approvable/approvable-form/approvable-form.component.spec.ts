import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApprovableFormComponent } from './approvable-form.component';

describe('ApprovableFormComponent', () => {
  let component: ApprovableFormComponent;
  let fixture: ComponentFixture<ApprovableFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ApprovableFormComponent]
    });
    fixture = TestBed.createComponent(ApprovableFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
