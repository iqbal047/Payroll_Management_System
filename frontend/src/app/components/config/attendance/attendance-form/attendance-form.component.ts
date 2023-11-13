import { Component } from '@angular/core';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
import { OperationStatus } from 'src/app/constants/status.enum';
import { Attendance } from 'src/app/model/config/attendance-model';
import { CrudService } from 'src/app/services/crud.service';
import { NotificationUtil } from 'src/app/utils/notification.util';
import { populateFormControl } from 'src/app/utils/object.util';

@Component({
  selector: 'app-attendance-form',
  templateUrl: './attendance-form.component.html',
  styleUrls: ['./attendance-form.component.scss']
})
export class AttendanceFormComponent {


  formGroup!: FormGroup;
  controls: any = {
    "isPresent": new FormControl('', []),
    // "logDate": new FormControl('', []),
    // "departmentHead": new FormControl('', []),
    // "PresentDays": new FormControl('', []),
    "remarks": new FormControl('', []),
    "hoursWorked": new FormControl('', []),
    "isOvertime": new FormControl('', []),
    // "OvertimeHour": new FormControl('', []),
    "location": new FormControl('', []),
    


  };
  submitted = false;
  endPoint = "attendance";
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
    const values: Attendance = { ...this.data, ...this.formGroup.value };
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
