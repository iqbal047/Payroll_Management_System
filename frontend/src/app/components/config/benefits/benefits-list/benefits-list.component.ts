import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AppResponse } from 'src/app/dto/response.dto';
import { Benefits } from 'src/app/model/config/benefits-model';
import { CrudService } from 'src/app/services/crud.service';

@Component({
  selector: 'app-benefits-list',
  templateUrl: './benefits-list.component.html',
  styleUrls: ['./benefits-list.component.scss']
})
export class BenefitsListComponent {

  displayedColumns: string[] = [ 'employee','benefitEnrollmentDate','benefitendDate',
  'benefitType','description','taxable','frequency', 'benefitCost','actions'];
    
  dataSource: Benefits[] = [];

  constructor(private service: CrudService, private router: Router) { }

  ngOnInit(): void {
    this.service.getList('benefits').subscribe((res: AppResponse) => {
      this.dataSource = res.data.content
    }
    );
  }

  delete(index: number) {
    let id = this.dataSource[index].id as number;
    this.service.delete(id, "benefits").subscribe(() => {
      const newData = this.dataSource.filter((s, i) => i != index);
      this.dataSource = newData;
    })
  }

  edit(index: number) {
    this.service.data = { ...this.dataSource[index] };
    this.router.navigate(['/benefits-form']);
  }
}
