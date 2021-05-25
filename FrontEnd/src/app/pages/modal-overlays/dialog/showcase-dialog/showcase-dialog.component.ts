import { Component, Input } from '@angular/core';
import { NbDialogRef } from '@nebular/theme';
import { HttpMatchsService } from '../../../../services/http-matchs.service';

@Component({
  selector: 'ngx-showcase-dialog',
  templateUrl: 'showcase-dialog.component.html',
  styleUrls: ['showcase-dialog.component.scss'],
})
export class ShowcaseDialogComponent {

  @Input() title: string;
  @Input() matche: any;
  @Input() joueurs: any[];
  @Input() event: any;

  constructor(protected ref: NbDialogRef<ShowcaseDialogComponent>) {}
  
  dismiss() {
    this.ref.close();
  }
}
