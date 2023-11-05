import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuditAbleFormComponent } from './audit-able-form.component';

describe('AuditAbleFormComponent', () => {
  let component: AuditAbleFormComponent;
  let fixture: ComponentFixture<AuditAbleFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AuditAbleFormComponent]
    });
    fixture = TestBed.createComponent(AuditAbleFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
