import { Component, Input } from '@angular/core';
import { NbDialogRef } from '@nebular/theme';

import { HttpBilletService } from '../../../../services/http-billet.service';
import { HttpArbitreService } from '../../../../services/http-arbitre.service';
import { HttpMatchsService } from '../../../../services/http-matchs.service';
import { HttpEquipeService } from '../../../../services/http-equipe.service';

@Component({
  selector: 'ngx-showcase-dialog',
  templateUrl: 'showcase-dialog.component.html',
  styleUrls: ['showcase-dialog.component.scss'],
})
export class ShowcaseDialogComponent {

  @Input() title: string;
  @Input() matche: any;
  @Input() arbitre: any;
  @Input() equipe: any;
  @Input() event: any;
  @Input() billet?: any

  constructor(protected ref: NbDialogRef<ShowcaseDialogComponent>, private httpMatchService: HttpMatchsService,
    private httpBilletService:HttpBilletService,
    private httpArbitreService: HttpArbitreService,
    private httpEquipeService: HttpEquipeService
    ) {}

  delete(){
    if(this.matche)
    this.httpMatchService.DeleteMatch(this.matche.match_id).subscribe(data => {
    });
    if(this.billet)
      this.httpBilletService.DeleteBillet(this.billet.billet_id).subscribe(data => {
      });  

    if(this.arbitre)
    this.httpArbitreService.deleteArbitre(this.arbitre.arbitre_id).subscribe(data => {
    });

    if(this.equipe)
    this.httpEquipeService.DeleteEquipe(this.equipe.equipe_id).subscribe(data => {
    });

    this.ref.close();
    this.event.confirm.resolve();
  }
  
  dismiss() {
    this.ref.close();
    this.event.confirm.reject();
  }
}
