import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuditTrailListComponent } from './audit-trail-list.component';

describe('AuditTrailListComponent', () => {
  let component: AuditTrailListComponent;
  let fixture: ComponentFixture<AuditTrailListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AuditTrailListComponent]
    });
    fixture = TestBed.createComponent(AuditTrailListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
