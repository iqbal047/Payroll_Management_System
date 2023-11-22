import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginResponse } from 'src/app/dto/login-response.dto';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  loginForm: FormGroup;

  constructor(
    private authService: AuthService,
    private rourter: Router,
    private formBuilder: FormBuilder
  ) {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  ngOnInit() {}

  login() {
    if (this.loginForm.valid) {
      // Perform login action here using form values:
      const formValues = this.loginForm.value;
      this.authService.login(formValues).subscribe((res: LoginResponse) => {
        sessionStorage.setItem('rs-token', res.accessToken as string);
        this.rourter.navigate(["/"]);
      });
      // E.g., calling an ausubscribetication service
      // authService.login(formValues.userIdEmail, formValues.password);
    } else {
      // Handle form validation errors here if needed
    }
  }
}
