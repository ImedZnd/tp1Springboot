import { Component } from '@angular/core';

@Component({
  selector: 'ngx-footer',
  styleUrls: ['./footer.component.scss'],
  template: `
  <span class="created-by">
    Created with ♥ by <b>Belhajamor Ahmed & Maghraoui Achraf & Hadhiri Wassim & El Echi Wael & Zenned Imed</b>
  </span>
  <div class="socials">
    Copyright © 2021
  </div>
  `,
})
export class FooterComponent {
}
