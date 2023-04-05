import { Injectable } from '@angular/core';
import {HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private url = 'http://localhost:8080/api/v1/employees';

  constructor(private http: HttpClient) { 
  }

  getEmployees(): Observable<any> {
    return this.http.get(`${this.url}`);
  }

  addEmployee(employee: Object): Observable<Object> {
    return this.http.post(`${this.url}`, employee);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`, {responseType: 'text'});
  }

}
