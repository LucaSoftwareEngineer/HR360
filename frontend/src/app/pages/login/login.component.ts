import { HttpClient, HttpClientModule, provideHttpClient } from '@angular/common/http';
import { Component, inject, OnInit } from '@angular/core';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [HttpClientModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  httpClient = inject(HttpClient);
  public data: Array<any> = [];
  constructor(httpClient: HttpClient) {}
  ngOnInit() {
  }

  loginDipendente() {
    this.httpClient.get('http://127.0.0.1:8080/dipendente/login/?username=luca&password=luca')
      .subscribe({
        next: (data: any) => {
          console.log(data);
          this.data = data;
        }, error: (err) => console.log(err)
      });
  }

}
