import { Component } from '@angular/core';
import { AccessService } from '../../services/access.service';
import { CommonModule } from '@angular/common';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  imports: [CommonModule,FormsModule,ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  constructor(private accessService : AccessService,private router : Router){}

  submitted : boolean = false;

  loginForm = new FormGroup({
    email : new FormControl('',[Validators.required,Validators.email]),
    password : new FormControl('',Validators.required)
  });

  get controls(){
    return this.loginForm.controls;
  }

  onsubmitted(){
    this.submitted = true;

     const email = this.loginForm.get('email')?.value;
     const password = this.loginForm.get('password')?.value

    this.accessService.login(email!,password!).subscribe({
      next: (response)=>{
        alert(response.message);
        sessionStorage.setItem('isLoggedIn','true');
        sessionStorage.setItem('userId', response.user.id); 
        this.router.navigate(['/venues'])
      },
      error: (error)=>{
        alert(error.error.message);
      }
    })
  }

  logout(){
    console.log("LOigging out");
    sessionStorage.removeItem('isLoggedIn');
  }

  
}

