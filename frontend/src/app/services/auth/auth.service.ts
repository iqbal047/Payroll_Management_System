import { Injectable } from '@angular/core';
import { User } from '../../model/auth/user';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppResponse } from '../../dto/response.dto';
import { ConfigService } from '../config/config.service';
import { LoginResponse } from '../../dto/login-response.dto';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient, private config: ConfigService, private router: Router) { }

  login(user: User): Observable<LoginResponse> {
    let url = `${this.config.apiUrl}/login`;
    return this.http.post<LoginResponse>(url, user);
  }

  checkLogin(): boolean {
    const token = sessionStorage.getItem('rs-token');
    return token !== null && token?.length > 8;
  }

  logout() {
    sessionStorage.clear();
    this.router.navigate(["/login"]);
  }

}
