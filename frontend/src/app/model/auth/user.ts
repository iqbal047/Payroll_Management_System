import { ApprovableEntity } from "../super-model/approvable-model";

export interface User extends ApprovableEntity{
    name?: string;
    username?: string;
    password?: string;
    roles?: string[];
}