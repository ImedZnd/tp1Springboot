import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HttpUserService {

  constructor(private httpClient: HttpClient) { }


  getUsers() {
    return this.httpClient.get<any[]>("http://localhost:8083/api/users/all");
  }

  addUtilisateur(utilisateur){
  return this.httpClient
  .post<any>("http://localhost:8083/api/users/add",utilisateur)


}

UpdateUtilisateur(utilisateur){
  return this.httpClient
  .put<any>("http://localhost:8083/api/users/update",utilisateur)
}

DeleteUtilisateur(id){
  return this.httpClient
  .delete<any>("http://localhost:8083/api/users/delete/"+id)
}

getUtilisateurByLogin(login){
  return this.httpClient.get<any>("http://localhost:8083/api/users/"+login);
}

}
