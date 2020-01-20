import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FormularioComponent } from './Pages/formulario/formulario.component';


import M from 'materialize-css';

import { AppRoutingModule }  from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { SuccessComponent } from './Pages/success/success.component';
import { LoginComponent } from './Pages/login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    FormularioComponent,
    SuccessComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
