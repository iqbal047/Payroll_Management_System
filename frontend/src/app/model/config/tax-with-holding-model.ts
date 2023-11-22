import { AuditAbleModel } from "../super-model/audit-able-model";
import { Employee } from "./employee-model";

export interface TaxWithholding extends AuditAbleModel {
    employee?:Employee;
    taxType?:string;
    taxAmount?:Number;

}