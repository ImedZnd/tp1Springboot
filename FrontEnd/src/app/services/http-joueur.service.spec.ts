import { TestBed } from '@angular/core/testing';

import { HttpJoueurService } from './http-joueur.service';

describe('HttpJoueurService', () => {
  let service: HttpJoueurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpJoueurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
