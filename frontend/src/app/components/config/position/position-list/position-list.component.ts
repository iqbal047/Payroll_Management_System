import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AppResponse } from 'src/app/dto/response.dto';
import { Position } from 'src/app/model/config/position-model';
import { CrudService } from 'src/app/services/crud.service';

@Component({
  selector: 'app-position-list',
  templateUrl: './position-list.component.html',
  styleUrls: ['./position-list.component.scss']
})
export class PositionListComponent {

  displayedColumns: string[] = ['positionTitle', 'salaryRange', 'actions'];
  dataSource: Position[] = [];

  constructor(private service: CrudService, private router: Router) { }

  ngOnInit(): void {
    this.service.getList('position').subscribe((res: AppResponse) => {
      this.dataSource = res.data.content
    }
    );
  }

  delete(index: number) {
    let id = this.dataSource[index].id as number;
    this.service.delete(id, "position").subscribe(() => {
      const newData = this.dataSource.filter((s, i) => i != index);
      this.dataSource = newData;
    })
  }

  edit(index: number) {
    this.service.data = { ...this.dataSource[index] };
    this.router.navigate(['/position-form']);
  }
}
