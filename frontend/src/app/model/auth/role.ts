import { ApprovableEntity } from "../super-model/approvable-model";

export interface Role extends ApprovableEntity {
    name?:string;
    permissions?:string[];
}