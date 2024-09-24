import { HttpClient, HttpClientModule, provideHttpClient } from '@angular/common/http';
import { Component, inject, OnInit } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [HttpClientModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  httpClient = inject(HttpClient);
  public data: Array<any> = [];

  username = new FormControl();
  password = new FormControl();

  constructor(httpClient: HttpClient) {}

  ngOnInit() {
  }

  loginDipendente() {
    let username_value = this.username.value;
    let password_value = this.password.value;
    this.httpClient.get('http://127.0.0.1:8080/dipendente/login?username='.concat(username_value).concat('&password=').concat(password_value))
      .subscribe({
        next: (data: any) => {
          console.log(data);
          this.data = data;
          if (data == 0) {
            console.log("accesso negato");
          } else {
            console.log("accesso consentito");
          }
        }, error: (err) => console.log(err)
      });
  }

}
