import { TestBed } from '@angular/core/testing';

import { HttpMatchsService } from './http-matchs.service';

describe('HttpMatchsService', () => {
  let service: HttpMatchsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpMatchsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
