import { Component, OnInit } from '@angular/core';
import { findFlagUrlByCountryName, countries  } from 'country-flags-svg';
@Component({
  selector: 'ngx-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.scss']
})
export class StatisticsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }


  getFlagUrl(eq:any){
   
      var flag = findFlagUrlByCountryName(eq)
      return flag;
    
    return null;
  }
/*
  getFlagUrl(equipe:any){
    var country = countries.filter(c => c.name.includes(equipe.name) || equipe.name.includes(c.iso3) || equipe.name.includes(c.altSpellings[0]))[0]; 
    if(country){
      var flag = findFlagUrlByCountryName(country.name)
      return flag;
    }
    return null;
  }
*/
}
