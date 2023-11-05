import { AuditAbleModel } from "../super-model/audit-able-model";

export interface Employee extends AuditAbleModel {
    firstName?:string;
    lastName?:string;
    dateOfBirth?:string;
    gender?:string;
    address?:string;
    phone?:string;
    email?:string;
    employmentStartDate?:string;
    department?:string;
    position?:string;
    employmentStatus?:string;
    bankAccountDetails?:string;
 
}