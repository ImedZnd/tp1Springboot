import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpJoueurService {

  constructor(private httpClient: HttpClient) { }

  getJoueurs() {
    return this.httpClient.get<any[]>("http://localhost:8083/api/joueur/all");
  }

  addJoueur(joueur){
  return this.httpClient.post<any>("http://localhost:8083/api/joueur/add",joueur)
}

UpdateJoueur(joueur){
  return this.httpClient.put<any>("http://localhost:8083/api/joueur/update",joueur)
}

DeleteJoueur(id){
  return this.httpClient.delete<any>("http://localhost:8083/api/joueur/delete/"+id)
}
}
