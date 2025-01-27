import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient) { }
  public login(form:any):Observable<any>{
    return this.http.post("http://localhost:8080/taskmgt/login",form);
  }
}
