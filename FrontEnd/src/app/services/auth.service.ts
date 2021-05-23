import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) {}


  authenticate(username, password) {
    return this.httpClient
      .post<any>("http://localhost:8083/api/users/authenticate", { username, password })
      .pipe(
        map(userData => {
          localStorage.setItem("username", username);
          let tokenStr = "Bearer " + userData.jwt;
          localStorage.setItem("token", tokenStr);
          return userData;
        })
      );
  }


  isUserLoggedIn() {
    let user = localStorage.get("username");
    console.log(!(user === null));
    return !(user === null);
  }

  getLoggedInUser(): any{
    if(this.isUserLoggedIn)
      return localStorage.get("username");
    else
      return null
  }

  logOut() {
    //this.cookieService.deleteAll();
    localStorage.clear()
  }
}
