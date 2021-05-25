import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatchtreeComponent } from './matchtree.component';

describe('MatchtreeComponent', () => {
  let component: MatchtreeComponent;
  let fixture: ComponentFixture<MatchtreeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatchtreeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatchtreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
