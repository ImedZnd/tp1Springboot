import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HttpMatchsService {

  constructor(private httpClient: HttpClient) { }


  getArbitres() {
    return this.httpClient.get<any[]>("http://localhost:8083/api/arbitre/all");
  }

  addArbitre(arbitre){
  return this.httpClient
  .post<any>("http://localhost:8083/api/arbitre/add",arbitre)


}

updateArbitre(arbitre){
  return this.httpClient
  .put<any>("http://localhost:8083/api/arbitre/update",arbitre)
}

deleteArbitre(id){
  return this.httpClient
  .delete<any>("http://localhost:8083/api/arbitre/delete/"+id)
}
}
