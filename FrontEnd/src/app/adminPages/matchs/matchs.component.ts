import { Component, OnInit } from '@angular/core';
import { NbDialogService } from '@nebular/theme';
import { LocalDataSource } from 'ng2-smart-table';
import { HttpEquipeService } from '../../services/http-equipe.service';
import { HttpMatchsService } from '../../services/http-matchs.service';
import { ShowcaseDialogComponent } from '../modal-overlays/dialog/showcase-dialog/showcase-dialog.component';
import { SmartTableDatepickerComponent, SmartTableDatepickerRenderComponent } from '../smart-table-datepicker/smart-table-datepicker.component';

@Component({
  selector: 'ngx-matchs',
  templateUrl: './matchs.component.html',
  styleUrls: ['./matchs.component.scss']
})
export class MatchsComponent implements OnInit {

  settings = {
    mode:'inline', 
    add: {
      addButtonContent: '<i class="nb-plus"></i>',
      createButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>',
      confirmCreate:true,
    },
    edit: {
      editButtonContent: '<i class="nb-edit"></i>',
      saveButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>',
      confirmSave : true,

    },
    delete: {
      deleteButtonContent: '<i class="nb-trash"></i>',
      confirmDelete: true,
    },
    columns: {
      match_id: {
        title: 'code',
        type: 'number',
        addable: false,
        editable:false
      },
      dateMatch: {
        title: 'Date',
        type: 'custom',
        renderComponent: SmartTableDatepickerRenderComponent,
        filter: false,
        sortDirection: 'desc',
        editor: {
          type: 'custom',
          component: SmartTableDatepickerComponent,
        }
      },
      status: {
        title: 'Status',
        editor:{
        type:'list',
        config: {
          selectText: 'Select',
          list: [{title:"LIVE", value:"LIVE"},{title:"PLAYED", value:"PLAYED"},{title:"SOON", value:"SOON"}]
        },
        },
      },
      phase: {
        title: 'Phase',
        editor:{
        type:'list',
        config: {
          selectText: 'Select',
          list: [
          {title:"PHASE_DE_POOL", value:"1"},
          {title:"SEIZIEME", value:"2"},
          {title:"HUITIEME", value:"3"},
          {title:"QUART_DE_FINALE", value:"4"},
          {title:"DEMI_FINALE", value:"5"},
          {title:"FINALE", value:"6"},
        ]
        },
        },
      },
      equipe1: {
        title: 'Equipe 1',
        editor:{
        type:'list',
        config: {
          selectText: 'Select',
          list: []
        },
        },
        valuePrepareFunction: (equipe1) => {
          return equipe1;
          
        },
        filterFunction(equipe1?: any, search?: string): boolean {
          let match1 = true;
          Object.keys(match1).map(u => equipe1.name).filter(it => {
            match1 = it.toLowerCase().includes(search);
          });

          if (match1 || search === '') {
            return true;
          } else {
            return false
          }
        },
        filter: true,
        compareFunction: (direction: any, a: any, b: any) => {
          let first = typeof a.nom === 'string' ? a.nom.toLowerCase(): a.nom;
          let second = typeof b.nom === 'string' ? b.nom.toLowerCase(): b.nom;

          if (first < second) {
            return -1 * direction;
          }
          if (first > second) {
            return direction;
          }
          return 0;
        }
      },
      equipe2: {
        title: 'Equipe 2',
        editor:{
        type:'list',
        config: {
          selectText: 'Select',
          list: []
        },
        },
        valuePrepareFunction: (equipe2) => {
          return equipe2;
          
        },
        filterFunction(equipe2?: any, search?: string): boolean {
          let match1 = true;
          Object.keys(match1).map(u => equipe2.name).filter(it => {
            match1 = it.toLowerCase().includes(search);
          });

          if (match1 || search === '') {
            return true;
          } else {
            return false
          }
        },
        filter: true,
        compareFunction: (direction: any, a: any, b: any) => {
          let first = typeof a.nom === 'string' ? a.nom.toLowerCase(): a.nom;
          let second = typeof b.nom === 'string' ? b.nom.toLowerCase(): b.nom;

          if (first < second) {
            return -1 * direction;
          }
          if (first > second) {
            return direction;
          }
          return 0;
        }
      },
    }
  }

  matches: any[];
  source: LocalDataSource;
  Equipes:any[];

  constructor(private httpMatchService: HttpMatchsService, private dialogService: NbDialogService,
  private httpEquipeService:HttpEquipeService) {
    this.source = new LocalDataSource(this.matches);
   }

  ngOnInit(): void {
    this.httpMatchService.getMatchs().subscribe(data => this.handleSuccessfulResponse(data));
    
    this.httpEquipeService.getEquipes().subscribe(data => this.Equipes=data);
    console.log(this.Equipes);

  }

  handleSuccessfulResponse(response) {
    console.log(response)

    this.matches = response;
    this.matches.forEach((m) => {
      if(m.equipes.length != 0){
      m.equipe1 = m.equipes[0].name;
      m.equipe2 =m.equipes[1].name;
      
      console.log(m.equipes[0]);
    }
      m.phase = m.phase.name;
    })
    console.log(this.matches);
    this.source.load(this.matches);
setTimeout(() => {
  this.settings.columns.equipe1.editor.config.list = this.Equipes.map(d => {
    return {'value':d.equipe_id, 'title': d.name}
  });
  this.settings = Object.assign({}, this.settings);
  this.settings.columns.equipe2.editor.config.list = this.Equipes.map(d => {
    return {'value':d.equipe_id, 'title': d.name}
  });
  this.settings = Object.assign({}, this.settings);
}, 500);
    
  }

  onDeleteConfirm(event){
    console.log(event.data);
    const diagRef = this.dialogService.open(ShowcaseDialogComponent, {
      context:{
        title: "Delete Match Confirmation",
        matche: event.data,
        event: event
      },
      closeOnBackdropClick: false
    }); 
  }

  addMatch(event){
    var matche = {
      "match_id": event.newData.match_id,
      "name": event.newData.name,
      "dateMatch": event.newData.dateMatch,
      "status": event.newData.status,
      "phase": event.newData.phase,
      "equipes":[]
    }
    matche.phase = {"phase_id": matche.phase};
    matche.equipes[0] = {"equipe_id":event.newData.equipe1}
    matche.equipes[1] = {"equipe_id":event.newData.equipe2}
    console.log(matche)
    this.httpMatchService.addMatch(matche).subscribe(data => {
      console.log(data);
      event.confirm.resolve(event.newData);
      this.matches.push(data);
      this.ngOnInit();
    })
  }

  editMatch(event){
    var matche = {
      "match_id": event.newData.match_id,
      "name": event.newData.name,
      "dateMatch": event.newData.dateMatch,
      "status": event.newData.status,
      "phase": event.newData.phase,
      "equipes":[]
    }
    matche.phase = {"phase_id": matche.phase};
    matche.equipes[0] = {"equipe_id":event.newData.equipe1}
    matche.equipes[1] = {"equipe_id":event.newData.equipe2}
    console.log(matche);
    this.httpMatchService.UpdateMatch(matche).subscribe(data => {
      console.log(data);
      event.confirm.resolve(event.newData);
      this.matches.push(data);
      this.ngOnInit();
    })

  }

}
