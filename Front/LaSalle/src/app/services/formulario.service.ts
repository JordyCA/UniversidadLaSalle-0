import { Injectable, Component } from '@angular/core';
import { FormularioModel } from '../Model/formulario.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { DatosusuarioModel } from '../Model/datosusuario.model';

@Injectable({
  providedIn: 'root'
})
export class FormularioService {

  private url = 'http://localhost:5000/';

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  public semestre: any = [
    {id:1, semestre: "Primer Semestre"},
    {id:2, semestre: "Segundo Semestre"},
    {id:3, semestre: "Tercer Semestre"},
    {id:4, semestre: "Cuarto semestre"},
    {id:5, semestre: "Quinto Semestre"},
    {id:6, semestre: "Sexto Semestre"},
    {id:7, semestre: "Septimo Semestre"},
    {id:8, semestre: "Octavo semestre"}
  ];

  public licenciatura: any = [
    {id:1, nombre: "Ingenieria de software"},
    {id:2, nombre: "Psicología"},
    {id:3, nombre: "Educación"},
    {id:4, nombre: "Mecatronica"},
    {id:5, nombre: "Derecho"}
  ];

  public maestria : any = [
    {id:6, nombre: "Maestría en peritajes"},
    {id:7, nombre: "Maestría en educación especial"},
    {id:8, nombre: "Maestría en manejo de negacios"}
  ];

  public doctorado : any = [
    {id:9, nombre: "Doctorado en investigación"},
    {id:10, nombre: "Doctorado en tecnologías"}
  ];

  public gradoAcademico : any[] = [
    {id:1, nombreGrado:'Maestría'},
    {id:2, nombreGrado:'Licenciatura'},
    {id:3, nombreGrado:'Doctorado'}
  ];


  constructor(private http: HttpClient, private router: Router) { }

  // Servicio para registrar un alumno
  crearAlumno (formulariomodel :FormularioModel) {
    console.log(formulariomodel);
    return this.http.post(this.url + `alumnoingreso`,formulariomodel);
  }

  // Servicio para verificar si existe el alumno
  checarUsuario(matricula:String){
    return this.http.get(this.url + `verificarusuario?matricula=` + matricula);
  }

  // Servicio para verificar si existe el alumno
  checaUsuario2() : Observable<any> {
    return this.http.get<any>(this.url + `verificarusuario`);
  }

  // Servicio para verificar si un alumno esta inscrito
  checarInscripcion(matricula:String){
    return this.http.get(this.url  + `verificarinscripcion?matricula=` + matricula);
  }
  
  validarAcceso(usuario:String, contrasena: String){
    //console.log(usuario + " " + contrasena);
    return this.http.get( this.url  + `accede?usuario=` + usuario + `&&contrasena=` + contrasena);
  }

  informacionUsuario(matricula: string){
    return this.http.get(this.url + `LaSalle/Alumno/Informacion?matricula=` + matricula);
  }

  actualizarInformacion(datosFormularioUsuario: DatosusuarioModel){
    return this.http.put(this.url + `LaSalle/Alumno/Modificar`,datosFormularioUsuario);
  }
}
