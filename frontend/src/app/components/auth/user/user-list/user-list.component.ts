import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppResponse } from 'src/app/dto/response.dto';
// import { AppResponse } from 'src/app/dto/response.dto';
import { User } from 'src/app/model/auth/user';
import { CrudService } from 'src/app/services/crud.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  displayedColumns: string[] = ['name','username','password','roles','actions'];
  dataSource: User[] = [];

  constructor(private service: CrudService, private router: Router) { }

  ngOnInit(): void {
    this.service.getList('user').subscribe((res: AppResponse) => {
      this.dataSource = res.data.content
    }
    );
  }

  // delete(index: number) {
  //   let id = this.dataSource[index].id as number;
  //   this.service.delete(id, "user").subscribe(() => {
  //     const newData = this.dataSource.filter((s, i) => i != index);
  //     this.dataSource = newData;
  //   })
  // }

  edit(index: number) {
    this.service.data = { ...this.dataSource[index] };
    this.router.navigate(['/user-form']);
  }
}


