import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormularioComponent } from './Pages/formulario/formulario.component';
import { SuccessComponent } from './Pages/success/success.component';
import { LoginComponent } from './Pages/login/login.component';

const routes: Routes = [
    { path: 'inscripcion', component: FormularioComponent},
    { path: 'inscipcion/succes', component: SuccessComponent},
    { path: 'LaSalle/ingresoAlumnos', component: LoginComponent},
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
  