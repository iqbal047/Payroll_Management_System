import { AuditAbleModel } from "../super-model/audit-able-model";
import { Employee } from "./employee-model";

export interface Salary extends AuditAbleModel {
    employee?:Employee;
    salaryAmount?:Number;
    payFrequency?:string;
    deductions?:Number;
    bonuses?:Number;





}