import { NgModule } from '@angular/core';
import { NbButtonModule, NbCardModule, NbDialogModule, NbListModule, NbMenuModule, NbSelectComponent, NbSelectModule } from '@nebular/theme';

import { ThemeModule } from '../@theme/theme.module';
import { PagesComponent } from './pages.component';
import { DashboardModule } from './dashboard/dashboard.module';
import { ECommerceModule } from './e-commerce/e-commerce.module';
import { PagesRoutingModule } from './pages-routing.module';
import { MiscellaneousModule } from './miscellaneous/miscellaneous.module';
import { MatchsComponent } from './matchs/matchs.component';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { EquipesComponent } from './equipes/equipes.component';
import { GroupesComponent } from './groupes/groupes.component';
import { NgxPayPalModule } from 'ngx-paypal';
import {BilletsaleComponent} from './billetsale/billetsale.component';
import { MatchtreeComponent } from './matchtree/matchtree.component';
import { TournamentTreeComponent } from './tournament-tree/tournament-tree.component';
import { NgttSingleEliminationTreeModule } from '../../../ng-tournament-tree/src/lib/single-elimination-tree/ngtt-single-elimination-tree.module';
import { NgttDoubleEliminationTreeModule } from '../../../ng-tournament-tree/src/lib/double-elimination-tree/ngtt-double-elimination-tree.module';
import { NgTournamentTreeModule } from '../../../ng-tournament-tree/src/lib/ng-tournament-tree.module';

@NgModule({
  imports: [
    PagesRoutingModule,
    ThemeModule,
    NbMenuModule,
    DashboardModule,
    ECommerceModule,
    MiscellaneousModule,
    Ng2SmartTableModule,
    NbCardModule,
    NbDialogModule.forRoot(),
    NbListModule,
    NbButtonModule,
    NgxPayPalModule,
    NbSelectModule,
    NgttSingleEliminationTreeModule,
    NgttDoubleEliminationTreeModule,
    NgTournamentTreeModule
    
  ],
  declarations: [
    PagesComponent,
    MatchsComponent,
    EquipesComponent,
    GroupesComponent,
    BilletsaleComponent,
    MatchtreeComponent,
    TournamentTreeComponent
  ],
})
export class PagesModule {
}
