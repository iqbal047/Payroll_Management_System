import { AuditAbleModel } from "../super-model/audit-able-model";
import { Employee } from "./employee-model";

export interface Department extends AuditAbleModel {
    departmentName?:string;
    // departmentHead?:Employee;
    description?:string;
    location?:string;
 

}