// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-devices',
//   templateUrl: './devices.component.html',
//   styleUrls: ['./devices.component.scss']
// })
// export class DevicesComponent {

// }


// devices.component.ts

import { Component } from '@angular/core';

@Component({
  selector: 'app-devices',
  templateUrl: './devices.component.html',
  styleUrls: ['./devices.component.scss'] // Update to your desired SCSS file name
})
export class DevicesComponent {
  plans = [
    { name: 'Basic', price: '$19.99', features: ['1 user', '10 projects', '24/7 support'] },
    { name: 'Pro', price: '$29.99', features: ['5 users', 'Unlimited projects', '24/7 priority support'] },
    { name: 'Enterprise', price: '$49.99', features: ['10 users', 'Unlimited projects', '24/7 dedicated support'] }
  ];
}

