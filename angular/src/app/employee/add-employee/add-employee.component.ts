import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import { EmployeeService } from 'src/app/employee.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router, private employeeService: EmployeeService) {
  }

  addForm!: FormGroup;

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      id: [],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      age: ['', Validators.required],
      emailAdress: ['', Validators.required],
      adress: ['', Validators.required],
      role: ['', Validators.required]
    });

  }

  onSubmit() {
    this.employeeService.addEmployee(this.addForm.value)
      .subscribe(data => {
        this.router.navigate(['list-employees']);
      });
  }

}
