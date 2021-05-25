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
    NbSelectModule
    
  ],
  declarations: [
    PagesComponent,
    MatchsComponent,
    EquipesComponent,
    GroupesComponent,
    BilletsaleComponent
  ],
})
export class PagesModule {
}
