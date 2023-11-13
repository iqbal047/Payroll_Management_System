import { AuditAbleModel } from "../super-model/audit-able-model";
import { Employee } from "./employee-model";

export interface TimeOff extends AuditAbleModel {
    // employee?:Employee;
    timeOffType?:string;
    // startDate?:Date;
    // endDate?:Date;
    approvalStatus?:string;

}