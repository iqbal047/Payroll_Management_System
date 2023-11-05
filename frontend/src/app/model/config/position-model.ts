import { AuditAbleModel } from "../super-model/audit-able-model";

export interface Position extends AuditAbleModel {
    positionTitle?:string;
    salaryRange?:number;
}