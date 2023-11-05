import { AuditAbleModel } from "../super-model/audit-able-model";

export interface Attachment extends AuditAbleModel {
    filePath?: string;
    fileName?: string;

}