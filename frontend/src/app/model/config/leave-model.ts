import { AuditAbleModel } from "../super-model/audit-able-model";
import { Employee } from "./employee-model";

export interface Leave extends AuditAbleModel {


    employee?:Employee;
    startDate?:Date;
    endDate?:Date;
    approved?:boolean;
    leaveType?:string;
    reason?:string;
    halfDay?:boolean;

}