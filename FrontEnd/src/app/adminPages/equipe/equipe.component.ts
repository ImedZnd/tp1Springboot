import { Component, OnInit } from '@angular/core';
import { NbDialogService } from '@nebular/theme';
import { LocalDataSource } from 'ng2-smart-table';
import { HttpEquipeService  } from '../../services/http-equipe.service';
import { ShowcaseDialogComponent } from '../modal-overlays/dialog/showcase-dialog/showcase-dialog.component';

@Component({
  selector: 'ngx-equipe',
  templateUrl: './equipe.component.html',
  styleUrls: ['./equipe.component.scss']
})
export class EquipeComponent implements OnInit {

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
      equipe_id: {
        title: 'code',
        type: 'number',
        addable: false,
        editable:false
      },
      name: {
        title: 'Nom',
        type: 'string',
      },
      points: {
        title: 'Points',
        type: 'number',
      },
    }
  }

  equipes: any[];
  source: LocalDataSource;

  constructor(private httpEquipeService: HttpEquipeService, private dialogService: NbDialogService) {
    this.source = new LocalDataSource(this.equipes);
   }

  ngOnInit(): void {
    this.httpEquipeService.getEquipes().subscribe(data => this.handleSuccessfulResponse(data))
  }

  handleSuccessfulResponse(response) {
    console.log(response)
    this.equipes = response;
    this.source.load(this.equipes);
  }

  onDeleteConfirm(event){
    console.log(event.data);
    const diagRef = this.dialogService.open(ShowcaseDialogComponent, {
      context:{
        title: "Delete Arbitre Confirmation",
        arbitre: event.data,
        event: event
      },
      closeOnBackdropClick: false
    }); 
  }

  addEquipe(event){
    var equipe = {
      "equipe_id": event.newData.equipe_id,
      "name": event.newData.name,
      "points": event.newData.points
    }

    console.log(equipe);

    this.httpEquipeService.addEquipe(equipe).subscribe(data => {
      console.log(data);
      event.confirm.resolve(event.newData);
      this.equipes.push(data);
      this.ngOnInit();
    })
  }

  editEquipe(event){
    var equipe = {
      "equipe_id": event.newData.equipe_id,
      "name": event.newData.name,
      "points": event.newData.points
    }

    console.log(equipe);

    this.httpEquipeService.UpdateEquipe(equipe).subscribe(data => {
      console.log(data);
      event.confirm.resolve(event.newData);
      this.equipes.push(data);
      this.ngOnInit();
    })

  }

}
