import { Injectable } from '@angular/core';
import { FormularioModel } from '../Model/formulario.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';

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

  constructor(private http: HttpClient) { }

  /*private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent){
      console.error('An error  ocurred:', error.error.message)
    } else {
      console.error(`Backend returned code ${error.status},` + `body was: ${error.error}`);
    }
    return throwError ('Something bad happended; please try again later.');
  }*/

  crearAlumno (formulariomodel :FormularioModel) {
    //console.log(formulario);
    //const params =  new HttpParams().set('idAlumnoMatricula',"333145222").set("nombre","juan").set("paterno","carrillo").set("materno","quintero").set("correo","andorid124@gmail.com").set("academico","ninguno");
    /*return this.http.post(`${ this.url }`, JSON.stringify(params),this.httpOptions)
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
      });*/
    //return this.http.post(`${ this.url }`, params);
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
  //
  }
}
