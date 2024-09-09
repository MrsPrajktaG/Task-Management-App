import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoriesService {

  constructor(private http:HttpClient) { }
  
  public addcategories(form:any):Observable<any>{
    return this.http.post("http://localhost:8080/taskmgt/addcategories",form);
  }

  public getAllCategories():Observable<any>{
    return this.http.get("http://localhost:8080/taskmgt/getAllCategories");
  }
}
