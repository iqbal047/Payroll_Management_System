import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
// import { AppResponse } from '../dto/response.dto';
import { ConfigService } from './config/config.service';
import { AppResponse } from '../dto/response.dto';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
    

  data: any = {};

  constructor(private http: HttpClient, private config: ConfigService) { }

  save(requestData: any, endPoint: string): Observable<AppResponse> {
    return this.http.post<AppResponse>(`${this.config.apiUrl}/${endPoint}/save`, requestData, {
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      }
    });
  }

  getAll(endPoint: string): Observable<AppResponse> {
    const url = `${this.config.apiUrl}/${endPoint}/list`;
    return this.http.get<AppResponse>(url);
  }

  getList(endPoint: string,
    pageNumber: number = 0,
    pageSize: number = 1000000000,
    sortDirection: string = 'NA',
    sortColumns: string = 'NA'
  ): Observable<AppResponse> {
    sortDirection = sortDirection == 'NA' ? '' : `/${sortDirection}`;
    sortColumns = sortColumns == 'NA' ? '' : `/${sortColumns}`;
    const url = `${this.config.apiUrl}/${endPoint}/list/${pageNumber}/${pageSize}${sortDirection}${sortColumns}`;
    return this.http.get<AppResponse>(url);
  }

  delete(id: number, endPoint: string): Observable<any> {
    return this.http.delete(`${this.config.apiUrl}/${endPoint}/delete/${id}`);
  }
}
