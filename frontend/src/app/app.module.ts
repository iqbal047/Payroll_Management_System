import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { RoleFormComponent } from './components/auth/role/role-form/role-form.component';
import { RoleListComponent } from './components/auth/role/role-list/role-list.component';
// import { CustomerFormComponent } from './components/config/customer/customer-form/customer-form.component';
// import { CustomerListComponent } from './components/config/customer/customer-list/customer-list.component';
import { EmployeeFormComponent } from './components/config/employee/employee-form/employee-form.component';
import { EmployeeListComponent } from './components/config/employee/employee-list/employee-list.component';
// import { ProductFormComponent } from './components/config/product/product-form/product-form.component';
// import { ProductListComponent } from './components/config/product/product-list/product-list.component';
// import { SettingFormComponent } from './components/config/setting/setting-form/setting-form.component';
// import { SettingListComponent } from './components/config/setting/setting-list/setting-list.component';
// import { SupplierFormComponent } from './components/config/supplier/supplier-form/supplier-form.component';
// import { SupplierListComponent } from './components/config/supplier/supplier-list/supplier-list.component';
// import { TeamFormComponent } from './components/config/team/team-form/team-form.component';
// import { TeamListComponent } from './components/config/team/team-list/team-list.component';
import { AttachmentFormComponent } from './components/data/attachment/attachment-form/attachment-form.component';
import { AttachmentListComponent } from './components/data/attachment/attachment-list/attachment-list.component';
import { AuditTrailFormComponent } from './components/data/audit-trail/audit-trail-form/audit-trail-form.component';
import { AuditTrailListComponent } from './components/data/audit-trail/audit-trail-list/audit-trail-list.component';
import { InventoryFormComponent } from './components/data/inventory/inventory-form/inventory-form.component';
import { InventoryListComponent } from './components/data/inventory/inventory-list/inventory-list.component';
import { NotificationFormComponent } from './components/data/notification/notification-form/notification-form.component';
import { NotificationListComponent } from './components/data/notification/notification-list/notification-list.component';
import { OrderFormComponent } from './components/data/order/order-form/order-form.component';
import { OrderListComponent } from './components/data/order/order-list/order-list.component';
import { PurchaseFormComponent } from './components/data/purchase/purchase-form/purchase-form.component';
import { PurchaseListComponent } from './components/data/purchase/purchase-list/purchase-list.component';
import { ApprovableFormComponent } from './components/super/approvable/approvable-form/approvable-form.component';
import { ApprovableListComponent } from './components/super/approvable/approvable-list/approvable-list.component';
import { AuditAbleFormComponent } from './components/super/audit-able/audit-able-form/audit-able-form.component';
import { AuditAbleListComponent } from './components/super/audit-able/audit-able-list/audit-able-list.component';
import { BaseFormComponent } from './components/super/base/base-form/base-form.component';
import { BaseListComponent } from './components/super/base/base-list/base-list.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
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
import { MatNativeDateModule } from '@angular/material/core';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatDatepickerModule } from '@angular/material/datepicker';

import { MatGridListModule } from '@angular/material/grid-list';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AttendanceFormComponent } from './components/config/attendance/attendance-form/attendance-form.component';
import { AttendanceListComponent } from './components/config/attendance/attendance-list/attendance-list.component';
import { LeaveFormComponent } from './components/config/leave/leave-form/leave-form.component';
import { LeaveListComponent } from './components/config/leave/leave-list/leave-list.component';
import { DashboardComponent } from './components/layout/dashboard/dashboard.component';

import { MatSidenavModule } from '@angular/material/sidenav';  
import { MatToolbarModule } from '@angular/material/toolbar';




@NgModule({
  declarations: [
    AppComponent,
    RoleFormComponent,
    RoleListComponent,    
    EmployeeFormComponent,
    EmployeeListComponent,
    AttachmentFormComponent,
    AttachmentListComponent,
    AuditTrailFormComponent,
    AuditTrailListComponent,
    InventoryFormComponent,
    InventoryListComponent,
    NotificationFormComponent,
    NotificationListComponent,
    OrderFormComponent,
    OrderListComponent,
    PurchaseFormComponent,
    PurchaseListComponent,
    ApprovableFormComponent,
    ApprovableListComponent,
    AuditAbleFormComponent,
    AuditAbleListComponent,
    BaseFormComponent,
    BaseListComponent,
    BenefitsFormComponent,
    BenefitsListComponent,
    DepartmentFormComponent,
    DepartmentListComponent,
    PaymentHistoryFormComponent,
    PaymentHistoryListComponent,
    PayrollTransactionFormComponent,
    PayrollTransactionListComponent,
    PositionFormComponent,
    PositionListComponent,
    SalaryFormComponent,
    SalaryListComponent,
    TaxWithholdingFormComponent,
    TaxWithholdingListComponent,
    TimeOffFormComponent,
    TimeOffListComponent,
    AttendanceFormComponent,
    AttendanceListComponent,
    LeaveFormComponent,
    LeaveListComponent,
    DashboardComponent,
 

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatTableModule,
    MatIconModule,
    MatButtonModule,
    MatSelectModule,
    MatInputModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    MatDatepickerModule,  
    MatNativeDateModule,
    MatGridListModule,
    MatSnackBarModule,
    NgbModule,


    MatSidenavModule,
    MatToolbarModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
