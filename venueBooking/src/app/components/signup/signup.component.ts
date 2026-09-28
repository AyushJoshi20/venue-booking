import { Component } from '@angular/core';
import { AccessService } from '../../services/access.service';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-signup',
  imports: [CommonModule,ReactiveFormsModule,FormsModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {

  constructor(private accessService : AccessService){}

  submitted : boolean = false;

  registrationForm = new FormGroup({
    name : new FormControl('',Validators.required),
    surname : new FormControl('',Validators.required),
    email : new FormControl('',[Validators.required,Validators.email]),
    password : new FormControl('',[Validators.required,Validators.minLength(6)])
  });

  get controls(){
    return this.registrationForm.controls;
  }

  onsubmitted(){
    this.submitted = true;
    this.accessService.register(this.registrationForm.value).subscribe({
      next: (response) =>{
        alert(response.message);
      },
      error : (error) =>{
        alert( error.error.message || "Resigtration Unsuccessful");
      }
    })
  }
}
