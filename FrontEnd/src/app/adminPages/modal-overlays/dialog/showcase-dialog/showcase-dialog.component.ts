import { Component, Input } from '@angular/core';
import { NbDialogRef } from '@nebular/theme';
import { HttpBilletService } from '../../../../services/http-billet.service';
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
  @Input() billet?: any

  constructor(protected ref: NbDialogRef<ShowcaseDialogComponent>, private httpMatchService: HttpMatchsService,
    private httpBilletService:HttpBilletService) {}

  delete(){
    if(this.matche)
    this.httpMatchService.DeleteMatch(this.matche.match_id).subscribe(data => {
    });
    if(this.billet)
      this.httpBilletService.DeleteBillet(this.billet.billet_id).subscribe(data => {
      });  
    this.ref.close();
    this.event.confirm.resolve();
  }
  
  dismiss() {
    this.ref.close();
    this.event.confirm.reject();
  }
}
