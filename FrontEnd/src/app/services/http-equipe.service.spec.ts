import { TestBed } from '@angular/core/testing';

import { HttpEquipeService } from './http-equipe.service';

describe('HttpEquipeService', () => {
  let service: HttpEquipeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpEquipeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
