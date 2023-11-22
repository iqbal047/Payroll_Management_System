import { Component } from '@angular/core';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';
import { OperationStatus } from 'src/app/constants/status.enum';
import { Page } from 'src/app/dto/page.dto';
import { AppResponse } from 'src/app/dto/response.dto';
import { Employee } from 'src/app/model/config/employee-model';
import { PayrollTransaction } from 'src/app/model/config/payroll-transaction-model';
import { Salary } from 'src/app/model/config/salary-model';
import { CrudService } from 'src/app/services/crud.service';
import { NotificationUtil } from 'src/app/utils/notification.util';
import { populateFormControl } from 'src/app/utils/object.util';

@Component({
  selector: 'app-payroll-transaction-form',
  templateUrl: './payroll-transaction-form.component.html',
  styleUrls: ['./payroll-transaction-form.component.scss']
})
export class PayrollTransactionFormComponent {


 
  formGroup!: FormGroup;
  controls: any = {
    "employee": new FormControl('', []),
    "payrollPeriod": new FormControl('', []),
    "salary": new FormControl('', []),
    "hoursWorked": new FormControl('', []),
    "overtimeHours": new FormControl('', []),
    "grossEarnings": new FormControl('', []),
    "deductions": new FormControl('', []),
    "netPay": new FormControl('', [])
  };
  submitted = false;
  endPoint = "payrolltransaction";
  data: any = {}
  employees: Employee[] = [];
  salaries: Salary[] = [];

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
    }),

    this.service.getList('salary', 0, 999999999).subscribe((res: AppResponse) =>{
      const page: Page = res.data;
      this.salaries = page.content;
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
       const values: PayrollTransaction = { ...this.data,
        ...this.formGroup.value,
        employee:{id: this.formGroup.value.employee},
        salary:{id: this.formGroup.value.salary}
      
      };

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
function res(value: AppResponse): AppResponse | PromiseLike<AppResponse> {
  throw new Error('Function not implemented.');
}

