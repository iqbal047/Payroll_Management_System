import { AuditAbleModel } from "../super-model/audit-able-model";
import { Employee } from "./employee-model";

export interface Attendance extends AuditAbleModel {
    
    // employee?:Employee;

    // logDate?:string;
    isPresent?:boolean;
    // PresentDays?:number;
    remarks?:string;
    hoursWorked?:number;
    isOvertime?:boolean;
    // OvertimeHour?:number;
    location?:string;


}