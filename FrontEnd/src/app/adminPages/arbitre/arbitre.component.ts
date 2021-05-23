import { Component, OnInit } from '@angular/core';
import { NbDialogService } from '@nebular/theme';
import { LocalDataSource } from 'ng2-smart-table';
import { HttpArbitreService  } from '../../services/http-arbitre.service';
import { ShowcaseDialogComponent } from '../modal-overlays/dialog/showcase-dialog/showcase-dialog.component';

@Component({
  selector: 'ngx-arbitre',
  templateUrl: './arbitre.component.html',
  styleUrls: ['./arbitre.component.scss']
})
export class ArbitreComponent implements OnInit {

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
      arbitre_id: {
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

  arbitres: any[];
  source: LocalDataSource;

  constructor(private httpArbitreService: HttpArbitreService, private dialogService: NbDialogService) {
    this.source = new LocalDataSource(this.arbitres);
   }

  ngOnInit(): void {
    this.httpArbitreService.getArbitres().subscribe(data => this.handleSuccessfulResponse(data))
  }

  handleSuccessfulResponse(response) {
    console.log(response)
    this.arbitres = response;
    this.source.load(this.arbitres);
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

  addArbitre(event){
    var arbitre = {
      "arbitre_id": event.newData.arbitre_id,
      "name": event.newData.name
    }

    console.log(arbitre);

    this.httpArbitreService.addArbitre(arbitre).subscribe(data => {
      console.log(data);
      event.confirm.resolve(event.newData);
      this.arbitres.push(data);
      this.ngOnInit();
    })
  }

  editArbitre(event){
    var arbitre = {
      "arbitre_id": event.newData.arbitre_id,
      "name": event.newData.name
    }
    console.log(arbitre);
    this.httpArbitreService.updateArbitre(arbitre).subscribe(data => {
      console.log(data);
      event.confirm.resolve(event.newData);
      this.arbitres.push(data);
      this.ngOnInit();
    })

  }


}
