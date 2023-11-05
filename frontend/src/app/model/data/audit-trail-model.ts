import { AuditAbleModel } from "../super-model/audit-able-model";

export interface AuditTrail extends AuditAbleModel {
    timestamp?:string;
    actionEventType?:string;
    userSystem?:string;
    affectedEntity?:string;
    iPAddress?:string;
    userAgent?:string;
    statusOutcome?:string;
    additionalMetadata?:string;
}