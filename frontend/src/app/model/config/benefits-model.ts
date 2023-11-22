import { AuditAbleModel } from "../super-model/audit-able-model";
import { Employee } from "./employee-model";

export interface Benefits extends AuditAbleModel {

    employee?:Employee;
    benefitEnrollmentDate?:Date;
    benefitendDate?:Date;
    benefitType?:string;
    description?:string;
    taxable?:boolean;
    frequency?:string;
    benefitCost?:Number;
    

} 