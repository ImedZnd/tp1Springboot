import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NbDialogService } from '@nebular/theme';
import { LocalDataSource } from 'ng2-smart-table';
import { HttpBilletService } from '../../services/http-billet.service';
import { ShowcaseDialogComponent } from '../modal-overlays/dialog/showcase-dialog/showcase-dialog.component';

@Component({
  selector: 'ngx-billet',
  templateUrl: './billet.component.html',
  styleUrls: ['./billet.component.scss']
})
export class BilletComponent implements OnInit {

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
      billet_id: {
        title: 'ID',
        type: 'number',
        addable: false,
        editable: false
      },
      categorie: {
        title: 'Categorie',
        type: 'string',
      }
      ,num_place: {
        title: 'Num_place',
        type: 'string',
      },
      prix: {
        title: 'Prix',
        type: 'string',
      },
      match: {
        title: 'match',
        editor:{
        type:'list',
        config: {
          selectText: 'Select',
          list: []
        },
        },
        valuePrepareFunction: (match) => {
          return match.name;
          
        },
        filterFunction(match?: any, search?: string): boolean {
          let match1 = true;
          Object.keys(match1).map(u => match.name).filter(it => {
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

      
    },
  };

    
  billet:any[];
  source: LocalDataSource;
  constructor(private httpBilletService: HttpBilletService,private router: Router, private dialogService: NbDialogService) {
    this.source = new LocalDataSource(this.billet);
  }

  handleSuccessfulResponse(response) {
    
    this.billet = response;

    this.source.load(response);
    this.settings.columns.match.editor.config.list = this.billet.map(b => {
      return {'value':b.match.match_id, 'title': b.match.name}
    });
    this.settings = Object.assign({}, this.settings);
    console.log(this.billet);

  }

  editBillet(event):void{
    var billet = {
      "billet_id":event.newData.billet_id,
      "categorie" : event.newData.categorie,
      "num_place" : event.newData.num_place,
      "prix":event.newData.prix,
      "match":event.newData.match,
    };
    
    console.log(billet);
    this.httpBilletService.UpdateBillet(billet).subscribe(data => {
      event.confirm.resolve(event.newData);
      this.billet.push(data);
      this.ngOnInit();


  });;
}

  addBillet(event): void{

   
    var billet = {
      "billet_id":event.newData.billet_id,
      "categorie" : event.newData.categorie,
      "num_place" : event.newData.num_place,
      "prix":event.newData.prix,
      "match":event.newData.match,
    };


       
    billet.match = {"match_id":billet.match};
    console.log(billet);
    this.httpBilletService.addBillet(billet).subscribe(data => {
      event.confirm.resolve(event.newData);
      this.billet.push(data);
      
      this.ngOnInit();
    },err => {
      console.log("errreurrr");
    })
  


  }

  onDeleteConfirm(event): void {
    const diagRef = this.dialogService.open(ShowcaseDialogComponent, {
      context:{
        title: "Delete pays Confirmation",
        billet: event.data,
        event: event

      },
      closeOnBackdropClick: false
    }); 
  }
  

  ngOnInit(): void {
    
    this.httpBilletService
    .getBillet()
    .subscribe(response => this.handleSuccessfulResponse(response));
    
  
  }

}
