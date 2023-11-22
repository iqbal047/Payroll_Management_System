import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AppResponse } from 'src/app/dto/response.dto';
import { TaxWithholding } from 'src/app/model/config/tax-with-holding-model';
import { CrudService } from 'src/app/services/crud.service';

@Component({
  selector: 'app-tax-with-holding-list',
  templateUrl: './tax-with-holding-list.component.html',
  styleUrls: ['./tax-with-holding-list.component.scss']
})
export class TaxWithholdingListComponent {

  displayedColumns: string[] = ['employee','taxType','taxAmount', 'actions'];
  dataSource: TaxWithholding[] = [];

  constructor(private service: CrudService, private router: Router) { }

  ngOnInit(): void {
    this.service.getList('taxwithholding').subscribe((res: AppResponse) => {
      this.dataSource = res.data.content
    }
    );
  }

  delete(index: number) {
    let id = this.dataSource[index].id as number;
    this.service.delete(id, "taxwithholding").subscribe(() => {
      const newData = this.dataSource.filter((s, i) => i != index);
      this.dataSource = newData;
    })
  }

  edit(index: number) {
    this.service.data = { ...this.dataSource[index] };
    this.router.navigate(['/taxwithholding-form']);
  }

}
