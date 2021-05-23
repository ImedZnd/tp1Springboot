import { Component, OnInit } from '@angular/core';
import { NbDialogService } from '@nebular/theme';
import { LocalDataSource } from 'ng2-smart-table';
import { HttpMatchsService } from '../../services/http-matchs.service';
import { ShowcaseDialogComponent } from '../modal-overlays/dialog/showcase-dialog/showcase-dialog.component';

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
      name: {
        title: 'Nom',
        type: 'string',
      },
    }
  }

  matches: any[];
  source: LocalDataSource;

  constructor(private httpMatchService: HttpMatchsService, private dialogService: NbDialogService) {
    this.source = new LocalDataSource(this.matches);
   }

  ngOnInit(): void {
    this.httpMatchService.getMatchs().subscribe(data => this.handleSuccessfulResponse(data))
  }

  handleSuccessfulResponse(response) {
    console.log(response)
    this.matches = response;
    this.source.load(this.matches);
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
      "name": event.newData.name
    }

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
      "name": event.newData.name
    }
    console.log(matche);
    this.httpMatchService.UpdateMatch(matche).subscribe(data => {
      console.log(data);
      event.confirm.resolve(event.newData);
      this.matches.push(data);
      this.ngOnInit();
    })

  }

}