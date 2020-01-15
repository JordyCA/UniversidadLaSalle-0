import { Injectable, Component } from '@angular/core';
import { FormularioModel } from '../Model/formulario.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Formulario2Model } from '../Model/formulario2.model';
import { Router } from '@angular/router';
import { PruebaComponent } from '../Pages/prueba/prueba.component';

@Injectable({
  providedIn: 'root'
})
export class FormularioService {

  private url = 'http://localhost:5000/alumnoingreso';

  
  datos = [];

  private  usuario :  any[];

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient, private router: Router) { }

  crearAlumno (formulariomodel :FormularioModel) {
    console.log(formulariomodel);

    return this.http.post(`http://localhost:5000/alumnoingreso`,formulariomodel)
       .subscribe(
      (val) => {
          console.log("POST call successful value returned in body", 
                      val);
      },
      response => {
          console.log("POST call in error", response);
      },
      () => {
          console.log("The POST observable is now completed.");
      });

  }

  checarUsuario(){

     return this.http.get(`http://localhost:5000/verificarusuario`)
        /*.subscribe((res)=>{
          //this.crearArrego(res);
          //console.log(res);
          var info = JSON.parse(JSON.stringify(res));
          this.datos = info["Id_Usuario"];
          console.log(this.datos);
        });
        /*.pipe(
          map(res =>  {
            this.crearArrego(res)
          })
        );*/
      //console.log(this.datos);

  
      //return this.usuario;
  }

  checaUsuario2() : Observable<any> {
    return this.http.get<any>(`http://localhost:5000/verificarusuario`);
  }
}
