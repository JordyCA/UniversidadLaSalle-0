import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormularioComponent } from './Pages/formulario/formulario.component';

const routes: Routes = [
    { path: 'inscripcion', component: FormularioComponent},
    { path: '**', pathMatch: 'full',component: FormularioComponent},
  ]

@NgModule({
    imports: [
      RouterModule.forRoot( routes )
    ],
    exports: [
      RouterModule
    ]
  })
  
  export class AppRoutingModule { }
  