import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AppResponse } from 'src/app/dto/response.dto';
// import { AppResponse } from 'src/app/dto/response.dto';
import { TimeOff } from 'src/app/model/config/time-off-model';
import { CrudService } from 'src/app/services/crud.service';

@Component({
  selector: 'app-time-off-list',
  templateUrl: './time-off-list.component.html',
  styleUrls: ['./time-off-list.component.scss']
})
export class TimeOffListComponent {

  displayedColumns: string[] = ['employee','timeOffType','startDate','endDate','approvalStatus', 'actions'];
  dataSource: TimeOff[] = [];

  constructor(private service: CrudService, private router: Router) { }

  ngOnInit(): void {
    this.service.getList('timeoff').subscribe((res: AppResponse) => {
      this.dataSource = res.data.content
    }
    );
  }

  delete(index: number) {
    let id = this.dataSource[index].id as number;
    this.service.delete(id, "timeoff").subscribe(() => {
      const newData = this.dataSource.filter((s, i) => i != index);
      this.dataSource = newData;
    })
  }

  edit(index: number) {
    this.service.data = { ...this.dataSource[index] };
    this.router.navigate(['/timeoff-form']);
  }

}
