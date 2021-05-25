import { Component, OnInit } from '@angular/core';



import { HttpMatchsService } from '../../services/http-matchs.service';
import { NbDialogService } from '@nebular/theme';
import { HttpBilletService } from '../../services/http-billet.service';
import { DialogNamePromptComponent } from '../modal-overlays/dialog/dialog-name-prompt/dialog-name-prompt.component';

@Component({
  selector: 'ngx-billetsale',
  templateUrl: './billetsale.component.html',
  styleUrls: ['./billetsale.component.scss']
})


export class BilletsaleComponent implements OnInit {


    

    constructor(private httpMatchsService: HttpMatchsService,private httpBilletService: HttpBilletService, private diaglog: NbDialogService) { }


    matches:any[]=[]
    billets: any[]=[]

    billet:any={
        prix: '105',
        categorie: 'VIP',
        match:{match_id:''}
    }

    price='40'

    ngOnInit(): void {
        this.httpMatchsService.getMatchs().subscribe(data =>this.handleSuccessfulResponse(data));
        this.httpBilletService.getBillet().subscribe(data =>this.billets=data);
      
    }

    

    handleSuccessfulResponse(response) {
        console.log(response)
        this.matches = response;
        this.matches = this.matches.filter(p=> p.status == "SOON")
        

        //this.equipes = this.matches.map(m => m.equipes.filter(e => e.name))
        console.log(this.billets)
    }


    editPrice(event){
        console.log(event)
        if(event=='VIP')
          this.price='105'
        else
          this.price='40'

      }

    

      toggleModal(_match){
        const diagRef = this.diaglog.open(DialogNamePromptComponent, {
            context:{
              match: _match,
              prix: this.price,
              type: this.price=='105'? 'VIP': 'Normal'
            },
            
          });
          console.log(_match)
      }

}
