import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuditTrailFormComponent } from './audit-trail-form.component';

describe('AuditTrailFormComponent', () => {
  let component: AuditTrailFormComponent;
  let fixture: ComponentFixture<AuditTrailFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AuditTrailFormComponent]
    });
    fixture = TestBed.createComponent(AuditTrailFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
