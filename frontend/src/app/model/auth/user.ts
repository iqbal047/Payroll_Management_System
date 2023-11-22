import { ApprovableEntity } from "../super-model/approvable-model";
import { Role } from "./role";

export interface User extends ApprovableEntity{
    name?: string;
    username?: string;
    password?: string;
    roles?: Array<Role>;
}
