import { Data } from "@angular/router";
import { AuditAbleModel } from "../super-model/audit-able-model";

export interface Employee extends AuditAbleModel {
    firstName?:string;
    lastName?:string;
    dateOfBirth?:Date;
    gender?:string;
    nationalId?:number;
    address?:string;
    phone?:string;
    email?:string;
    employmentStartDate?:Date;
    department?:string;
    designation?:string;
    // position?:string;
    employmentStatus?:string;
    bankAccountDetails?:string;
 
}