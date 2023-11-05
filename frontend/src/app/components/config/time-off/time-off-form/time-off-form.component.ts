import { Component } from '@angular/core';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
import { OperationStatus } from 'src/app/constants/status.enum';
import { TimeOff } from 'src/app/model/config/time-off-model';
import { CrudService } from 'src/app/services/crud.service';
import { NotificationUtil } from 'src/app/utils/notification.util';
import { populateFormControl } from 'src/app/utils/object.util';

@Component({
  selector: 'app-time-off-form',
  templateUrl: './time-off-form.component.html',
  styleUrls: ['./time-off-form.component.scss']    
})
export class TimeOffFormComponent {

  formGroup!: FormGroup;
  controls: any = {
    "employee": new FormControl('', []),
    "taxType": new FormControl('', []),
    "startDate": new FormControl('', []),
    "endDate": new FormControl('', []),
    "approvalStatus": new FormControl('', [])
   
  
  };
  submitted = false;
  endPoint = "timeoff";
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
    const values: TimeOff = { ...this.data, ...this.formGroup.value };
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
