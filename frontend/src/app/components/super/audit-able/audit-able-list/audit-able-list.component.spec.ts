import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuditAbleListComponent } from './audit-able-list.component';

describe('AuditAbleListComponent', () => {
  let component: AuditAbleListComponent;
  let fixture: ComponentFixture<AuditAbleListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AuditAbleListComponent]
    });
    fixture = TestBed.createComponent(AuditAbleListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
