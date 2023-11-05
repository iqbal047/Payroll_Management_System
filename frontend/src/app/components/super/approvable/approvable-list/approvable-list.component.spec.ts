import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApprovableListComponent } from './approvable-list.component';

describe('ApprovableListComponent', () => {
  let component: ApprovableListComponent;
  let fixture: ComponentFixture<ApprovableListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ApprovableListComponent]
    });
    fixture = TestBed.createComponent(ApprovableListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
