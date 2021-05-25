import { Component, OnInit } from '@angular/core';
import { HttpMatchsService } from '../../services/http-matchs.service';
import { map } from 'rxjs/operators';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'ngx-match-direct',
  templateUrl: './match-direct.component.html',
  styleUrls: ['./match-direct.component.scss']
})
export class MatchDirectComponent implements OnInit {

matches:any[]
liveMatches?:any[]=[]

  constructor(private httpMatchsService:HttpMatchsService) { }

  ngOnInit(): void {
    this.httpMatchsService.getMatchs().subscribe(data =>this.handleSuccessfulResponse(data));
   }   

  handleSuccessfulResponse(response) {
    this.matches = response;
    this.liveMatches = this.matches.filter(one => one.status === "LIVE")
    console.log(this.liveMatches)
  }

  editScore(event,selectedMatch:any){
    var match = {
      "match_id": selectedMatch.match_id,
      "name": selectedMatch.name,
      "status": "LIVE",
      "phase": selectedMatch.phase,
      "equipes": selectedMatch.equipes,
      "scoreEquipe1":event,
      "scoreEquipe2":selectedMatch.scoreEquipe2
    }
    console.log(match);
    this.httpMatchsService.UpdateMatch(match).subscribe(data => {
      console.log(data);
      this.ngOnInit();
    })
  }

  editScore2(event,selectedMatch:any){
    var match = {
      "match_id": selectedMatch.match_id,
      "name": selectedMatch.name,
      "status": "LIVE",
      "phase": selectedMatch.phase,
      "equipes": selectedMatch.equipes,
      "scoreEquipe1":selectedMatch.scoreEquipe1,
      "scoreEquipe2":event
    }
    console.log(match);
    this.httpMatchsService.UpdateMatch(match).subscribe(data => {
      console.log(data);
      this.ngOnInit();
    })
  }
}
