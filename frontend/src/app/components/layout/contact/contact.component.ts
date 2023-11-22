import { Component } from '@angular/core';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent {
  model = {
    name: '',
    email: '',
    phoneNumber: '',
    companyName: '',
    message: ''
  };

  onSubmit() {
    // Handle form submission logic here
    console.log('Form submitted:', this.model);
  }
}
