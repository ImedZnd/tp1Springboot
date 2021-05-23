import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HttpMatchsService {

  constructor(private httpClient: HttpClient) { }


  getMatchs() {
    return this.httpClient.get<any[]>("http://localhost:8083/api/match/all");
  }

  addMatch(matche){
  return this.httpClient
  .post<any>("http://localhost:8083/api/match/add",matche)


}

UpdateMatch(matche){
  return this.httpClient
  .put<any>("http://localhost:8083/api/match/update",matche)
}

DeleteMatch(id){
  return this.httpClient
  .delete<any>("http://localhost:8083/api/match/delete/"+id)
}
}
