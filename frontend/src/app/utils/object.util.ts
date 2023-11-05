export const populateFormControl = (controls: any, data: any): void => {
    const keys = Object.keys(data);
    keys.forEach((prop: string) => {
        if (controls[prop]) {
            controls[prop].setValue(data[prop]);
        }
    })
}