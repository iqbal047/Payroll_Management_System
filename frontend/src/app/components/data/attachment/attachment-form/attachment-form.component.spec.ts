import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AttachmentFormComponent } from './attachment-form.component';

describe('AttachmentFormComponent', () => {
  let component: AttachmentFormComponent;
  let fixture: ComponentFixture<AttachmentFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AttachmentFormComponent]
    });
    fixture = TestBed.createComponent(AttachmentFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
