import { AuditAbleModel } from "../super-model/audit-able-model";
import { Employee } from "./employee-model";

export interface Benefits extends AuditAbleModel {
    employee?:Employee;
    benefitType?:string;
    benefitCost?:Number;
    // benefitEnrollmentDate?:Date;

}