import { AuditAbleModel } from "../super-model/audit-able-model";
import { Employee } from "./employee-model";

export interface Attendance extends AuditAbleModel {
    
    
    employee?:Employee;
    logDate?:Date;
    present?:boolean;
    remarks?:string;
    hoursWorked?:number;
    overtime?:boolean;
    location?:string;
   


}