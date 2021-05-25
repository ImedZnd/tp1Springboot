import { Component, OnInit } from '@angular/core';
import { NbDialogService } from '@nebular/theme';
import { LocalDataSource } from 'ng2-smart-table';
import { findFlagUrlByCountryName, countries  } from 'country-flags-svg';
import { HttpMatchsService } from '../../services/http-matchs.service';
import { ShowcaseDialogComponent } from '../modal-overlays/dialog/showcase-dialog/showcase-dialog.component';

@Component({
  selector: 'ngx-matchs',
  templateUrl: './matchs.component.html',
  styleUrls: ['./matchs.component.scss']
})
export class MatchsComponent implements OnInit {

 

  data={
    "match_id": 1,
    "name": "Tunis VS USA : PHASE_DE_POOL",
    "dateMatch": null,
    "winner_id": null,
    "scoreEquipe1": null,
    "scoreEquipe2": null,
    "status": null,
    "phase": {
        "phase_id": 1,
        "name": "PHASE_DE_POOL",
        "tournoi": {
            "tournoi_id": 1,
            "nameTournoi": "super leage"
        }
    },
    "equipes": [
        {
            "equipe_id": 1,
            "name": "Tunis",
            "points": 0
        },
        {
            "equipe_id": 2,
            "name": "USA",
            "points": 0
        }
    ]
}


matches:any[]=[]
equipes:any[]=[]
flagUrl: any[] = [];
liveMatches:any[]
  constructor(private httpMatchsService:HttpMatchsService) { }

  ngOnInit(): void {
    this.httpMatchsService.getMatchs().subscribe(data =>this.handleSuccessfulResponse(data));
    
  }
 

  getFlagUrl(equipe:any){
    var country = countries.filter(c => c.name.includes(equipe.name) || equipe.name.includes(c.iso3) || equipe.name.includes(c.altSpellings[0]))[0];
    if(country){
      var flag = findFlagUrlByCountryName(country.name)
      return flag;
    }
    return null;
  }

  handleSuccessfulResponse(response) {
    console.log(response)
    this.matches = response;
    this.matches = this.matches.filter(p=> p.phase.name == "PHASE_DE_POOL")
    this.equipes = this.matches.map(m => m.equipes.filter(e => e.name))
    console.log(this.equipes)
    
  }

  editScore(event){
    var match = {
      "match_id": event.newData.match_id,
      "name": event.newData.name
    }
    console.log(match);
    this.httpMatchsService.UpdateMatch(match).subscribe(data => {
      console.log(data);
      event.confirm.resolve(event.newData);
      this.liveMatches.push(data);
      this.ngOnInit();
    })
  }
  }
