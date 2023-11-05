import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Role } from '../../../../model/auth/role';
import { CrudService } from '../../../../services/crud.service';

@Component({
  selector: 'app-role-form',
  templateUrl: './role-form.component.html',
  styleUrls: ['./role-form.component.scss']
})
export class RoleFormComponent implements OnInit {
  roleForm!: FormGroup;
  submitted = false;
  endPoint = "role";

  constructor(private formBuilder: FormBuilder, private service: CrudService) { }

  ngOnInit() {
    this.createForm();
  }

  createForm() {
    this.roleForm = this.formBuilder.group({
      name: ['', Validators.required],
      permissions: ['', Validators.required]
    });
  }

  submitForm() {
    this.submitted = true;

    if (this.roleForm.invalid) {
      // Handle validation errors, e.g., mark fields as touched and display error messages
      return;
    }

    const roleData: Role = this.roleForm.value;
    this.service.save(roleData,this.endPoint ).subscribe(response => {
      // Handle the response from the service (e.g., show a success message)
      // Optionally, you can reset the form after successful submission
      this.roleForm.reset();
      this.submitted = false;
    });
  }
}
