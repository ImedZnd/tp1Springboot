import { Component, OnInit } from '@angular/core';
import { HttpMatchsService } from '../../services/http-matchs.service';
import { map } from 'rxjs/operators';
import { filter } from 'rxjs/operators';
import { HttpEquipeService } from '../../services/http-equipe.service';

@Component({
  selector: 'ngx-match-direct',
  templateUrl: './match-direct.component.html',
  styleUrls: ['./match-direct.component.scss']
})
export class MatchDirectComponent implements OnInit {

matches:any[]
matches2:any[]
liveMatches?:any[]=[]
eqq:any={}

  constructor(private httpMatchsService:HttpMatchsService,private httpEquipeService:HttpEquipeService) { }

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

  terminateMatch(event,selectedMatch:any){
    var winner_id
    if(selectedMatch.scoreEquipe1==selectedMatch.scoreEquipe2){
      winner_id=null
      console.log(winner_id)
    }
    if(selectedMatch.scoreEquipe1>selectedMatch.scoreEquipe2) 
    {
      winner_id=selectedMatch.equipes[0].equipe_id
      console.log(winner_id)
    }
    else {
      if(selectedMatch.scoreEquipe1<selectedMatch.scoreEquipe2)
      {
        winner_id=selectedMatch.equipes[1].equipe_id
        console.log(winner_id)
      }
    }
    if(winner_id!=null){

        this.httpEquipeService.getOneEquipe(winner_id).subscribe(
        data=>{
         var winnerEquipe={
            "equipe_id": data.equipe_id,
            "name": data.name,
            "points": data.points
          }
          console.log(winnerEquipe)
          this.eqq=winnerEquipe
      }
    )
    this.eqq.points+=3
    this.httpEquipeService.UpdateEquipe(this.eqq).subscribe(
      data=>{
        console.log("UpdateEquipe of the winner "+data)
    }
  )  

  var match = {
    "match_id": selectedMatch.match_id,
    "name": selectedMatch.name,
    "status": "PLAYED",
    "winner_id":winner_id,
    "phase": selectedMatch.phase,
    "equipes": selectedMatch.equipes,
    "scoreEquipe1":selectedMatch.scoreEquipe1,
    "scoreEquipe2":selectedMatch.scoreEquipe2
  }
  console.log(match);
  this.httpMatchsService.UpdateMatch(match).subscribe(data => {
    console.log("result from UpdateMatch :"+data);
    this.ngOnInit();
  })


    }
    else
    {
      this.httpEquipeService.getOneEquipe(selectedMatch.equipes[0].equipe_id).subscribe(
        data=>{
         var winnerEquipe={
            "equipe_id": data.equipe_id,
            "name": data.name,
            "points": data.points
          }
          console.log(winnerEquipe)
          this.eqq=winnerEquipe
      }
    )
    this.eqq.points+=1
    this.httpEquipeService.UpdateEquipe(this.eqq).subscribe(data=>console.log(data))  
    this.httpEquipeService.getOneEquipe(selectedMatch.equipes[1].equipe_id).subscribe(
      data=>{
       var winnerEquipe={
          "equipe_id": data.equipe_id,
          "name": data.name,
          "points": data.points
        }
        console.log(winnerEquipe)
        this.eqq=winnerEquipe
    }
  )
  this.eqq.points+=1
  this.httpEquipeService.UpdateEquipe(this.eqq).subscribe(data=>console.log(data))  
    }
  }
}
