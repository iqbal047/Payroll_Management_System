import { OperationStatus } from "../constants/status.enum";
import { Page } from "./page.dto";

export interface AppResponse {
    status: OperationStatus;
    message: string | null;
    data?: any;
}
