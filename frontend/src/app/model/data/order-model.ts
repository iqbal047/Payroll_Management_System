import { AuditAbleModel } from "../super-model/audit-able-model";

export interface Order extends AuditAbleModel {
    OrderDate?:string;
    customer?:string;
    employee?:string;
    paymentMethod?:string;
    paymentDate?:string;
    shippingAddress?:string;
    billingAddress?:string;
    orderStatus?:string;
    totalAmount?:string;
    taxAmount?:string;
    discountAmount?:string;
    shippingFee?:string;
    invoiceReceiptNumber?:string;
    notesComments?:string;
    deliveryDate?:string;
    returnExchangeRequest?:string;
    returnExchangeDate?:string;
}