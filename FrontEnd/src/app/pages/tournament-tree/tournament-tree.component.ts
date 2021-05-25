import { Component, OnInit } from '@angular/core';
import { NgttTournament } from '../../../../ng-tournament-tree/src/lib/declarations/interfaces';

import { HttpMatchsService } from '../../services/http-matchs.service';

@Component({
  selector: 'ngx-tournament-tree',
  templateUrl: './tournament-tree.component.html',
  styleUrls: ['./tournament-tree.component.scss']
})
export class TournamentTreeComponent implements OnInit {
  public singleEliminationTournament: NgttTournament;
  matches:any[];
  constructor(private httpMatchesService:HttpMatchsService) { }

  ngOnInit(): void {
    this.httpMatchesService.getMatchs().subscribe(data=>console.log(data),err=>console.log("mochkel"));
    
    this.singleEliminationTournament = {
      rounds: [
        {



          type: 'Winnerbracket',
          matches: [
            {
              teams: [{name: 'Team  USA', score: 1}, {name: 'Team  B', score: 2}]
            },
            {
              teams: [{name: 'Team  C', score: 1}, {name: 'Team  D', score: 2}]
            },
            {
              teams: [{name: 'Team  E', score: 1}, {name: 'Team  F', score: 2}]
            },
            {
              teams: [{name: 'Team  G', score: 1}, {name: 'Team  H', score: 2}]
            }, {
              teams: [{name: 'Team  A', score: 1}, {name: 'Team  B', score: 2}]
            },
            {
              teams: [{name: 'Team  C', score: 1}, {name: 'Team  D', score: 2}]
            },
            {
              teams: [{name: 'Team  E', score: 1}, {name: 'Team  F', score: 2}]
            },
            {
              teams: [{name: 'Team  G', score: 1}, {name: 'Team  H', score: 2}]
            }
          ]
        }, {
          type: 'Winnerbracket',
          matches: [
            {
              teams: [{name: 'Team  A', score: 1}, {name: 'Team  B', score: 2}]
            },
            {
              teams: [{name: 'Team  C', score: 1}, {name: 'Team  D', score: 2}]
            },
            {
              teams: [{name: 'Team  E', score: 1}, {name: 'Team  F', score: 2}]
            },
            {
              teams: [{name: 'Team  G', score: 1}, {name: 'Team  H', score: 2}]
            }
          ]
        },
        {
          type: 'Winnerbracket',
          matches: [
            {
              teams: [{name: 'Team  B', score: 1}, {name: 'Team  D', score: 2}]
            },
            {
              teams: [{name: 'Team  F', score: 1}, {name: 'Team  H', score: 2}]
            }
          ]
        },
        {
          type: 'Final',
          matches: [
            {
              teams: [
                {
                  name: 'Team  D',
                  score: 1
                },
                {
                  name: 'Team  H',
                  score: 2
                }
              ]
            },
            {
              teams: [
                {
                  name: 'Team  F',
                  score: 1
                },
                {
                  name: 'Team  B',
                  score: 2
                }
              ]
            }
          ]
        }
      ]
    };
  }

}