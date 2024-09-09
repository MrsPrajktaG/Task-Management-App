import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }

  public adduser(form:any):Observable<any>{
    return this.http.post("http://localhost:8080/taskmgt/addUser",form);
  }
  public getAllGroups():Observable<any>{
    return this.http.get("http://localhost:8080/taskmgt/allGroups")
  }
  public getAllPermissionsById(id:any):Observable<any>{
    return this.http.get(`http://localhost:8080/taskmgt/getPermissionById/${id}`)
  }
  public getGroupById(id:any):Observable<any>{
    return this.http.get(`http://localhost:8080/taskmgt/getGroupById/${id}`)
  }
  public getAllUser():Observable<any>{
    return this.http.get("http://localhost:8080/taskmgt/getAllUser")
  }
  public updatePermissions(permission:any):Observable<any>{
    return this.http.put("http://localhost:8080/taskmgt/updatePermissions", permission);
  }
}
