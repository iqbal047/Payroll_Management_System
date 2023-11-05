export interface ApprovableEntity {
    isApproved?: boolean;
    approvedBy?: string;
    denialReason?: string;
    approvedAt?: Date;
}