import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatchDirectComponent } from './match-direct.component';

describe('MatchDirectComponent', () => {
  let component: MatchDirectComponent;
  let fixture: ComponentFixture<MatchDirectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatchDirectComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatchDirectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
