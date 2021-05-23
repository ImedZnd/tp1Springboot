import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpEquipeService {

  constructor(private httpClient: HttpClient) { }

  getEquipes() {
    return this.httpClient.get<any[]>("http://localhost:8083/api/equipe/all");
  }

  addEquipe(matche){
  return this.httpClient.post<any>("http://localhost:8083/api/equipe/add",matche)
}

UpdateEquipe(matche){
  return this.httpClient.put<any>("http://localhost:8083/api/equipe/update",matche)
}

DeleteEquipe(id){
  return this.httpClient.delete<any>("http://localhost:8083/api/equipe/delete/"+id)
}
}
