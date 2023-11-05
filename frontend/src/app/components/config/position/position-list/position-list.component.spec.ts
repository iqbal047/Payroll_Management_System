import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PositionListComponent } from './position-list.component';

describe('PositionListComponent', () => {
  let component: PositionListComponent;
  let fixture: ComponentFixture<PositionListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PositionListComponent]
    });
    fixture = TestBed.createComponent(PositionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
