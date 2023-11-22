import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AppResponse } from 'src/app/dto/response.dto';
import { PaymentHistory } from 'src/app/model/config/payment-history-model';
import { CrudService } from 'src/app/services/crud.service';

@Component({
  selector: 'app-payment-history-list',
  templateUrl: './payment-history-list.component.html',
  styleUrls: ['./payment-history-list.component.scss']
})
export class PaymentHistoryListComponent {


  displayedColumns: string[] = [ 'employee', 'paymentDate', 'paymentAmount', 'paymentMethod','paymentStatus','actions'];
  
  dataSource: PaymentHistory[] = [];

  constructor(private service: CrudService, private router: Router) { }

  ngOnInit(): void {
    this.service.getList('paymenthistory').subscribe((res: AppResponse) => {
      this.dataSource = res.data.content
    }
    );
  }

  delete(index: number) {
    let id = this.dataSource[index].id as number;
    this.service.delete(id, "paymenthistory").subscribe(() => {
      const newData = this.dataSource.filter((s, i) => i != index);
      this.dataSource = newData;
    })
  }

  edit(index: number) {
    this.service.data = { ...this.dataSource[index] };
    this.router.navigate(['/paymenthistory-form']);
  }
}
