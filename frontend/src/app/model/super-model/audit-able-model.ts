import { BaseModel } from "./base-model";

export interface AuditAbleModel extends BaseModel {
    createdBy?:string;
    createdDate?:Date;
    modifiedBy?:string;
    modifiedDate?:Date;
}