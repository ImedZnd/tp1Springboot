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
  @Input() event: any;

  constructor(protected ref: NbDialogRef<ShowcaseDialogComponent>, private httpMatchService: HttpMatchsService) {}

  delete(){
    if(this.matche)
    this.httpMatchService.DeleteMatch(this.matche.match_id).subscribe(data => {
    });
    this.ref.close();
    this.event.confirm.resolve();
  }
  
  dismiss() {
    this.ref.close();
    this.event.confirm.reject();
  }
}
