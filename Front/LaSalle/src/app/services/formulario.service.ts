import { Injectable, Component } from '@angular/core';
import { FormularioModel } from '../Model/formulario.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class FormularioService {

  private url = 'http://localhost:5000/alumnoingreso';

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient, private router: Router) { }

  crearAlumno (formulariomodel :FormularioModel) {
    console.log(formulariomodel);
    return this.http.post(`http://localhost:5000/alumnoingreso`,formulariomodel);
  }

  checarUsuario(matricula:String){
    return this.http.get(`http://localhost:5000/verificarusuario?matricula=` + matricula);
  }

  checarInscripcion(matricula:String){
    return this.http.get(`http://localhost:5000/verificarinscripcion?matricula=` + matricula);
  }

  checaUsuario2() : Observable<any> {
    return this.http.get<any>(`http://localhost:5000/verificarusuario`);
  }

  //verificar el usuario http://localhost:5000/accede?usuario=112300111&&contrasena=tnGR6!a6@5

}
