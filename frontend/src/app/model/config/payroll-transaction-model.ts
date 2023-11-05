import { AuditAbleModel } from "../super-model/audit-able-model";
import { Employee } from "./employee-model";
import { Salary } from "./salary-model";

export interface PayrollTransaction extends AuditAbleModel {
    employee?:Employee;
    payrollPeriod?:string;
    salary?:Salary;
    hoursWorked?:number;
    overtimeHours?:number;
    grossEarnings?:number;
    deductions?:number;
    netPay?:number;
}