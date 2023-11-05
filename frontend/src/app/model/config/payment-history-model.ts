import { AuditAbleModel } from "../super-model/audit-able-model";
import { Employee } from "./employee-model";

export interface PaymentHistory extends AuditAbleModel {
    employee?:Employee;
    paymentDate?:Date;
    paymentAmount?:number;
    paymentMethod?:string;
    paymentStatus?:string;



}