import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HttpBilletService {

  constructor(private httpClient: HttpClient) { }

  getBillet() {
    return this.httpClient.get<any[]>("http://localhost:8083/api/billet/all");
  }

  addBillet(matche){
  return this.httpClient.post<any>("http://localhost:8083/api/billet/add",matche)
}

UpdateBillet(matche){
  return this.httpClient.put<any>("http://localhost:8083/api/billet/update",matche)
}

DeleteBillet(id){
  return this.httpClient.delete<any>("http://localhost:8083/api/billet/delete/"+id)
}
}
