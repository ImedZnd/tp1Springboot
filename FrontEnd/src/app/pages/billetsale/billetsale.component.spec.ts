import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BilletsaleComponent } from './billetsale.component';

describe('BilletsaleComponent', () => {
  let component: BilletsaleComponent;
  let fixture: ComponentFixture<BilletsaleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BilletsaleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BilletsaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
