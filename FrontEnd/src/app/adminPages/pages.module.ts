import { NgModule } from '@angular/core';
import { NbCardModule, NbDialogModule, NbMenuModule } from '@nebular/theme';

import { ThemeModule } from '../@theme/theme.module';
import { PagesComponent } from './pages.component';
import { DashboardModule } from './dashboard/dashboard.module';
import { ECommerceModule } from './e-commerce/e-commerce.module';
import { PagesRoutingModule } from './pages-routing.module';
import { MiscellaneousModule } from './miscellaneous/miscellaneous.module';
import { MatchsComponent } from './matchs/matchs.component';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { ArbitreComponent } from './arbitre/arbitre.component';
import { JoueurComponent } from './joueur/joueur.component';
import { BilletComponent } from './billet/billet.component';
import { EquipeComponent } from './equipe/equipe.component';
import { MatchDirectComponent } from './match-direct/match-direct.component';
import { NbListModule } from '@nebular/theme';
import { NbSelectModule } from '@nebular/theme';

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
    NbSelectModule
  ],
  declarations: [
    PagesComponent,
    MatchsComponent,
    ArbitreComponent,
    JoueurComponent,
    BilletComponent,
    EquipeComponent,
    MatchDirectComponent,
  ],
})
export class PagesModule {
}
