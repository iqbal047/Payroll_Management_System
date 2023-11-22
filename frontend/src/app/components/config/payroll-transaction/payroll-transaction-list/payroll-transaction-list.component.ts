import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AppResponse } from 'src/app/dto/response.dto';
import { PayrollTransaction } from 'src/app/model/config/payroll-transaction-model';
import { CrudService } from 'src/app/services/crud.service';

@Component({
  selector: 'app-payroll-transaction-list',
  templateUrl: './payroll-transaction-list.component.html',
  styleUrls: ['./payroll-transaction-list.component.scss']   
})
export class PayrollTransactionListComponent {


  displayedColumns: string[] = ['employee', 'payrollPeriod','salary', 'hoursWorked',
  'overtimeHours','grossEarnings','deductions','netPay', 'actions'];
  
  dataSource: PayrollTransaction[] = [];

  constructor(private service: CrudService, private router: Router) { }

  ngOnInit(): void {
    this.service.getList('payrolltransaction').subscribe((res: AppResponse) => {
      this.dataSource = res.data.content
    }
    );
  }

  delete(index: number) {
    let id = this.dataSource[index].id as number;
    this.service.delete(id, "payrolltransaction").subscribe(() => {
      const newData = this.dataSource.filter((s, i) => i != index);
      this.dataSource = newData;
    })
  }

  edit(index: number) {
    this.service.data = { ...this.dataSource[index] };
    this.router.navigate(['/payrolltransaction-form']);
  }
}
