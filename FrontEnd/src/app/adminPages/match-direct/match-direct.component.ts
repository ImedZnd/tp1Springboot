import { Component, OnInit } from '@angular/core';
import { HttpMatchsService } from '../../services/http-matchs.service';
import { map } from 'rxjs/operators';
import 'rxjs/add/observable/of';

@Component({
  selector: 'ngx-match-direct',
  templateUrl: './match-direct.component.html',
  styleUrls: ['./match-direct.component.scss']
})
export class MatchDirectComponent implements OnInit {


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
liveMatches:any[]
  constructor(private httpMatchsService:HttpMatchsService) { }

  ngOnInit(): void {
    this.httpMatchsService.getMatchs().subscribe(data =>this.handleSuccessfulResponse(data));
  }

  handleSuccessfulResponse(response) {
    console.log(response)
    this.matches = response;
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
