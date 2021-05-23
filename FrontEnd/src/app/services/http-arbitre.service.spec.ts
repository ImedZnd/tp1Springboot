import { TestBed } from '@angular/core/testing';

import { HttpArbitreService } from './http-arbitre.service';

describe('HttpArbitreService', () => {
  let service: HttpArbitreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpArbitreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
