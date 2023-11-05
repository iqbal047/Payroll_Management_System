import { Component } from '@angular/core';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';
import { OperationStatus } from 'src/app/constants/status.enum';
import { PaymentHistory } from 'src/app/model/config/payment-history-model';
import { CrudService } from 'src/app/services/crud.service';
import { NotificationUtil } from 'src/app/utils/notification.util';
import { populateFormControl } from 'src/app/utils/object.util';

@Component({
  selector: 'app-payment-history-form',
  templateUrl: './payment-history-form.component.html',
  styleUrls: ['./payment-history-form.component.scss']
})
export class PaymentHistoryFormComponent {


  formGroup!: FormGroup;
  controls: any = {
    "employee": new FormControl('', []),
    "paymentDate": new FormControl('', []),
    "paymentAmount": new FormControl('', []),
    "paymentMethod": new FormControl('', []),
    "paymentStatus": new FormControl('', [])
  };
  submitted = false;
  endPoint = "paymenthistory";
  data: any = {}

  constructor(private formBuilder: FormBuilder, private service: CrudService, private noticeUtil: NotificationUtil) { }

  ngOnInit() {
    this.createForm();
    this.data = this.service.data;
    if (this.data.id) {
      populateFormControl(this.formGroup.controls, this.data);
    }
  }

  createForm() {
    this.formGroup = this.formBuilder.group(this.controls);
  }

  submitForm() {
    this.submitted = true;
    if (this.formGroup.invalid) {
      return;
    }
    const values: PaymentHistory = { ...this.data, ...this.formGroup.value };
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
