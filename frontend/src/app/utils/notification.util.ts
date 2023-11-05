import { AppResponse } from './../dto/response.dto';
import { Injectable } from "@angular/core";
import { MatSnackBar, MatSnackBarConfig } from "@angular/material/snack-bar";
import { OperationStatus } from '../constants/status.enum';

@Injectable({
    providedIn: 'root'
})
export class NotificationUtil {
    constructor(private snackbar: MatSnackBar) { }

    showResponseMessage(response: AppResponse): void {
        const config: MatSnackBarConfig<any> = {
            duration: 3000,
            verticalPosition: 'top',
            panelClass: response.status === OperationStatus.SUCCESS ? 'success-snackbar' : 'error-snackbar'
        };
        this.snackbar.open(response.message as string, undefined, config);
    }
}

