import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { UserService } from '../../service/user.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-start',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './start.component.html',
  styleUrl: './start.component.css'
})
export class StartComponent implements OnInit{
  userForm!: FormGroup;
  constructor(private userService: UserService, private router:Router, private toastr: ToastrService){
  }

  ngOnInit(){
    this.userForm = new FormGroup({
      userName: new FormControl(),
      email: new FormControl()
    })
  }

  submit(){
    this.userService.summitUser(this.userForm.value).subscribe({next:
      (res) => {
        localStorage.setItem('email', this.userForm.value.email);
        this.router.navigateByUrl("/topic");
      },
      error: (err) => {
        const errorMessage = err.error?.message;
        this.toastr.error(errorMessage);
      }
    })
  }
}
