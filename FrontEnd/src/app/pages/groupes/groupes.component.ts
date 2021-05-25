import { Component, OnInit } from '@angular/core';
import { HttpMatchsService } from '../../services/http-matchs.service';
import { findFlagUrlByCountryName, countries  } from 'country-flags-svg';

@Component({
  selector: 'ngx-groupes',
  templateUrl: './groupes.component.html',
  styleUrls: ['./groupes.component.scss']
})
export class GroupesComponent implements OnInit {

  groupeTitles = ["GROUPE A", "GROUPE B", "GROUPE C"]
  matches: any[] = [];
  equipes: any[] = [];
  constructor(private httpMatchService: HttpMatchsService) { }

  ngOnInit(): void {
    this.httpMatchService.getMatchs().subscribe(data => this.handleSuccessfulResponse(data));
  }

  handleSuccessfulResponse(response) {
    this.matches = response;
    this.equipes = this.matches.map(m => m.equipes.filter(e => e))
    console.log(this.equipes)
    
  }

  getFlagUrl(equipe:any){
    var country = countries.filter(c => c.name.includes(equipe.name) || equipe.name.includes(c.iso3) || equipe.name.includes(c.altSpellings[0]))[0];
    if(country){
      var flag = findFlagUrlByCountryName(country.name)
      return flag;
    }
    return null;
  }

}
