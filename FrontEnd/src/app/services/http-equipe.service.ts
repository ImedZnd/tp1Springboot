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

  addEquipe(equipe){
  return this.httpClient.post<any>("http://localhost:8083/api/equipe/add",equipe)
}

UpdateEquipe(equipe){
  return this.httpClient.put<any>("http://localhost:8083/api/equipe/update",equipe)
}

DeleteEquipe(id){
  return this.httpClient.delete<any>("http://localhost:8083/api/equipe/delete/"+id)
}
}
