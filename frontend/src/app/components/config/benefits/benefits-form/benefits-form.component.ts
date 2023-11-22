import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { OperationStatus } from 'src/app/constants/status.enum';
import { Page } from 'src/app/dto/page.dto';
import { AppResponse } from 'src/app/dto/response.dto';
import { Benefits } from 'src/app/model/config/benefits-model';
import { Employee } from 'src/app/model/config/employee-model';
import { CrudService } from 'src/app/services/crud.service';
import { NotificationUtil } from 'src/app/utils/notification.util';
import { populateFormControl } from 'src/app/utils/object.util';

@Component({
  selector: 'app-benefits-form',
  templateUrl: './benefits-form.component.html',
  styleUrls: ['./benefits-form.component.scss']
})
export class BenefitsFormComponent {

  formGroup!: FormGroup;
  controls: any = {
    "employee": new FormControl('', []),
    "benefitEnrollmentDate": new FormControl('', []),
    "benefitendDate": new FormControl('', []),
    "benefitType": new FormControl('', []),
    "description": new FormControl('', []),
    "taxable": new FormControl('', []),
    "frequency": new FormControl('', []),
    "benefitCost": new FormControl('', []),

  };
  submitted = false;
  endPoint = "benefits";
  data: any = {}
  employees: Employee[] = [];

  constructor(private formBuilder: FormBuilder, private service: CrudService, private noticeUtil: NotificationUtil) { }

  ngOnInit() {
    this.createForm();
    this.data = this.service.data;
    if (this.data.id) {
      populateFormControl(this.formGroup.controls, this.data);
    }
    this.service.getList('employee', 0, 999999999).subscribe((res: AppResponse) =>{
      const page: Page = res.data;
      this.employees = page.content;
    })
  }

  createForm() {
    this.formGroup = this.formBuilder.group(this.controls);
  }

  submitForm() {
    this.submitted = true;
    if (this.formGroup.invalid) {
      return;
    }
    const values: Benefits = { ...this.data,
       ...this.formGroup.value,
       employee:{id: this.formGroup.value.employee} };
       
    this.service.save(values, this.endPoint).subscribe(response => {
      this.formGroup.reset();
      this.submitted = false;
      this.noticeUtil.showResponseMessage(response);
    },
    (error: Error) => {
      const res = {status: OperationStatus.FAILURE, message: "Server error! Please contact with support team."};
      this.noticeUtil.showResponseMessage(res);
      console.log(this.endPoint, error);
    });
  }

}
