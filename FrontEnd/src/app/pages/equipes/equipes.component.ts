import { Component, OnInit } from '@angular/core';
import { HttpEquipeService } from '../../services/http-equipe.service';
import { findFlagUrlByCountryName, countries  } from 'country-flags-svg';
import { NbDialogService } from '@nebular/theme';
import { ShowcaseDialogComponent } from '../modal-overlays/dialog/showcase-dialog/showcase-dialog.component';

@Component({
  selector: 'ngx-equipes',
  templateUrl: './equipes.component.html',
  styleUrls: ['./equipes.component.scss']
})
export class EquipesComponent implements OnInit {

  flagUrl: any[] = [];
  equipes: any[] = [];
  constructor(private httpEquipeService: HttpEquipeService, private diaglog: NbDialogService) { }

  ngOnInit(): void {
    this.httpEquipeService.getEquipes().subscribe(data => this.handleSuccessfulResponse(data))
  }

  handleSuccessfulResponse(response) {
    this.equipes = response;
  }

  builRow(){
    var tab = [];
    for(var i=0; i< this.equipes.length; i+=3){
      var row = [];
      for(var x = 0; x < 3; x++){
        var value = this.equipes[i+x];
        if(!value){
          break;
        }
        row.push(value);
      }
      tab.push(row);
    }
    return tab;
  }

  getFlagUrl(equipe:any){
    var country = countries.filter(c => c.name.includes(equipe.name) || equipe.name.includes(c.iso3) || equipe.name.includes(c.altSpellings[0]))[0];
    if(country){
      var flag = findFlagUrlByCountryName(country.name)
      return flag;
    }
    return null;
  }

  showJouers(event,equipe){
    console.log(equipe)
    const diagRef = this.diaglog.open(ShowcaseDialogComponent, {
      context:{
        title: "Liste des Joueurs de : "+equipe.name,
        equipe: equipe,
      },
      closeOnBackdropClick: false
    }); 
  }

}
