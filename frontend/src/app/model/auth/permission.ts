import { BaseModel } from "../super-model/base-model";

export interface Permission extends BaseModel {
    name?: string;
    componentKey?: string;
    description?: string;
    category?: string;
}