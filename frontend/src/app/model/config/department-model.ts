import { AuditAbleModel } from "../super-model/audit-able-model";
import { Employee } from "./employee-model";

export interface Department extends AuditAbleModel {

    departmentHead?:Employee;
    departmentName?:string;
    description?:string;
    location?:string;
 

}