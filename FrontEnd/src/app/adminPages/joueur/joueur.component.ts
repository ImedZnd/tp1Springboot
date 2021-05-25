import { Component, OnInit } from '@angular/core';
import { LocalDataSource } from 'ng2-smart-table';
import { NbDialogService } from '@nebular/theme';
import { HttpJoueurService } from '../../services/http-joueur.service';
import { ShowcaseDialogComponent } from '../modal-overlays/dialog/showcase-dialog/showcase-dialog.component';
import { HttpEquipeService } from '../../services/http-equipe.service';

@Component({
  selector: 'ngx-joueur',
  templateUrl: './joueur.component.html',
  styleUrls: ['./joueur.component.scss']
})
export class JoueurComponent implements OnInit {


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
      joueur_id: {
        title: 'code',
        type: 'number',
        addable: false,
        editable:false
      },
      name: {
        title: 'Nom',
        type: 'string',
      },
      equipe: {
        title: 'Equipe',
        editor:{
        type:'list',
        config: {
          selectText: 'Select',
          list: []
        },
        },
        valuePrepareFunction: (equipe) => {
          return equipe.name;

        },
        filterFunction(equipe?: any, search?: string): boolean {
          let match = true;
          Object.keys(equipe).map(u => equipe.name).filter(it => {
            match = it.toLowerCase().includes(search);
          });

          if (match || search === '') {
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

  joueurs: any[];
  equipes: any[];
  source: LocalDataSource;

  constructor(private httpJoueurService: HttpJoueurService,
    private dialogService: NbDialogService,
    private httpEquipeService:HttpEquipeService) 
    {
    this.source = new LocalDataSource(this.joueurs)
   }

  ngOnInit(): void {
    this.httpEquipeService.getEquipes().subscribe(data=>this.equipes=data)
    this.httpJoueurService.getJoueurs().subscribe(data=>this.handleSuccessfulResponse(data))
  }

  handleSuccessfulResponse(response) {
    console.log(response)
    this.joueurs = response;
    this.source.load(this.joueurs);
    this.settings.columns.equipe.editor.config.list = this.equipes.map(p => {
      return {'value':p.equipe_id, 'title': p.name}
    });
    this.settings = Object.assign({}, this.settings);
  }

  onDeleteConfirm(event){
    console.log(event.data);
    const diagRef = this.dialogService.open(ShowcaseDialogComponent, {
      context:{
        title: "Delete Joueur Confirmation",
        matche: event.data,
        event: event
      },
      closeOnBackdropClick: false
    }); 
  }

  addMatch(event){
    var joueur = {
      "joueur_id": event.newData.joueur_id,
      "name": event.newData.name
    }

    this.httpJoueurService.addJoueur(joueur).subscribe(data => {
      console.log(data);
      event.confirm.resolve(event.newData);
      this.joueurs.push(data);
      this.ngOnInit();
    })
  }

  editMatch(event){
    var joueur = {
      "joueur_id": event.newData.match_id,
      "name": event.newData.name
    }
    console.log(joueur);
    this.httpJoueurService.UpdateJoueur(joueur).subscribe(data => {
      console.log(data);
      event.confirm.resolve(event.newData);
      this.joueurs.push(data);
      this.ngOnInit();
    })

  }
}
