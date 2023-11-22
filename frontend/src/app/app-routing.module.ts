import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RoleFormComponent } from './components/auth/role/role-form/role-form.component';
import { RoleListComponent } from './components/auth/role/role-list/role-list.component';
import { EmployeeFormComponent } from './components/config/employee/employee-form/employee-form.component';
import { EmployeeListComponent } from './components/config/employee/employee-list/employee-list.component';
import { BenefitsFormComponent } from './components/config/benefits/benefits-form/benefits-form.component';
import { BenefitsListComponent } from './components/config/benefits/benefits-list/benefits-list.component';
import { DepartmentFormComponent } from './components/config/department/department-form/department-form.component';
import { DepartmentListComponent } from './components/config/department/department-list/department-list.component';
import { PaymentHistoryFormComponent } from './components/config/payment-history/payment-history-form/payment-history-form.component';
import { PaymentHistoryListComponent } from './components/config/payment-history/payment-history-list/payment-history-list.component';
import { PayrollTransactionFormComponent } from './components/config/payroll-transaction/payroll-transaction-form/payroll-transaction-form.component';
import { PayrollTransactionListComponent } from './components/config/payroll-transaction/payroll-transaction-list/payroll-transaction-list.component';
import { PositionFormComponent } from './components/config/position/position-form/position-form.component';
import { PositionListComponent } from './components/config/position/position-list/position-list.component';
import { SalaryFormComponent } from './components/config/salary/salary-form/salary-form.component';
import { SalaryListComponent } from './components/config/salary/salary-list/salary-list.component';
import { TaxWithholdingFormComponent } from './components/config/tax-with-holding/tax-with-holding-form/tax-with-holding-form.component';
import { TaxWithholdingListComponent } from './components/config/tax-with-holding/tax-with-holding-list/tax-with-holding-list.component';
import { TimeOffFormComponent } from './components/config/time-off/time-off-form/time-off-form.component';
import { TimeOffListComponent } from './components/config/time-off/time-off-list/time-off-list.component';
import { AttendanceFormComponent } from './components/config/attendance/attendance-form/attendance-form.component';
import { AttendanceListComponent } from './components/config/attendance/attendance-list/attendance-list.component';
import { LeaveFormComponent } from './components/config/leave/leave-form/leave-form.component';
import { LeaveListComponent } from './components/config/leave/leave-list/leave-list.component';
import { DashboardComponent } from './components/layout/dashboard/dashboard.component';
import { SidemenuComponent } from './components/layout/sidemenu/sidemenu.component';
import { HomeComponent } from './components/layout/home/home.component';
import { AboutComponent } from './components/layout/about/about.component';
import { ContactComponent } from './components/layout/contact/contact.component';
import { canActivate, canActivateChild } from './services/auth/auth-guard';
import { LoginComponent } from './components/layout/login-page/login/login.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './services/interceptors/auth-interceptor.service';
import { DevicesComponent } from './components/layout/devices/devices.component';

// import { SidemenuComponent } from './admin-panel/sidemenu/sidemenu.component';

const routes: Routes = [
  {
    // path: '', component: DashboardComponent,
    path: '', component: SidemenuComponent,
    canActivate: [canActivate],
    canActivateChild: [canActivateChild],
  children: [
    // {path: '', component: RoleFormComponent},
    // {path: 'list', component: RoleListComponent},
    { path: 'home', component: HomeComponent },
    { path: 'devices', component: DevicesComponent },
    { path: 'about', component: AboutComponent },
    { path: 'contact', component: ContactComponent },
    { path: 'dashboard', component: DashboardComponent },
    {path: 'attendance-form', component: AttendanceFormComponent},
    {path: 'attendance-list', component: AttendanceListComponent},
    {path: 'employee-form', component: EmployeeFormComponent},
    {path: 'employee-list', component: EmployeeListComponent},
    {path: 'benefits-form', component: BenefitsFormComponent},
    {path: 'benefits-list', component: BenefitsListComponent},
    {path: 'department-form', component: DepartmentFormComponent},
    {path: 'department-list', component: DepartmentListComponent},
    {path: 'payment-history-form', component: PaymentHistoryFormComponent},
    {path: 'payment-history-list', component: PaymentHistoryListComponent},
    {path: 'payroll-transaction-form', component: PayrollTransactionFormComponent},
    {path: 'payroll-transaction-list', component: PayrollTransactionListComponent},
    {path: 'position-form', component: PositionFormComponent},
    {path: 'position-list', component: PositionListComponent},
    {path: 'salary-form', component: SalaryFormComponent},
    {path: 'salary-list', component: SalaryListComponent},
    {path: 'tax-with-holding-form', component: TaxWithholdingFormComponent},
    {path: 'tax-with-holding-list', component: TaxWithholdingListComponent},
    // {path: 'time-off-form', component: TimeOffFormComponent},
    // {path: 'time-off-list', component: TimeOffListComponent},
    {path: 'leave-form', component: LeaveFormComponent},
    {path: 'leave-list', component: LeaveListComponent}
  ]
},
{
  path: 'login', component: LoginComponent
},

  // {path: 'dashboard-list', component: LeaveListComponent}
];

// @NgModule({
//   imports: [RouterModule.forRoot(routes)],
//   exports: [RouterModule]
// })
// export class AppRoutingModule { }
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
})
export class AppRoutingModule {}
