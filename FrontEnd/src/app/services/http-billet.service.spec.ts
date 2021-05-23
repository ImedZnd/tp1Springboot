import { TestBed } from '@angular/core/testing';

import { HttpBilletService } from './http-billet.service';

describe('HttpBilletService', () => {
  let service: HttpBilletService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpBilletService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
