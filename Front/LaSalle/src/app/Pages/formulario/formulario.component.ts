import { Component, OnInit } from '@angular/core';
import { FormularioService } from '../../services/formulario.service';
import { NgForm, FormGroup, FormControl } from '@angular/forms';
import { FormularioModel } from '../../Model/formulario.model';

import M from'materialize-css';
import { MaterializeModule } from 'angular2-materialize';
import { analyzeNgModules } from '@angular/compiler';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
  //providers: [FormularioService]
})
export class FormularioComponent implements OnInit {

  constructor( private formularioService : FormularioService) { }
  
  private especialidad : any[] ;
  private usuario2 : any;
  private manejoErroresUsuario :  string = ""; 
  private manejoErroresRegistrado :  string = ""; 
  private manejoErroresGeneral :  string = ""; 
  private manejoErroresSemestre :  string = ""; 


  datos : any []; 
  datos2 : any[]; 
  usuario : any[];

  private semestre: any = [
    {id:1, semestre: "Primer Semestre"},
    {id:2, semestre: "Segundo Semestre"},
    {id:3, semestre: "Tercer Semestre"},
    {id:4, semestre: "Cuarto semestre"},
    {id:5, semestre: "Quinto Semestre"},
    {id:6, semestre: "Sexto Semestre"},
    {id:7, semestre: "Septimo Semestre"},
    {id:8, semestre: "Octavo semestre"}
  ];

  private licenciatura: any = [
    {id:1, nombre: "Ingenieria de software"},
    {id:2, nombre: "Psicología"},
    {id:3, nombre: "Educación"},
    {id:4, nombre: "Mecatronica"},
    {id:5, nombre: "Derecho"}
  ];

  private maestria : any = [
    {id:6, nombre: "Maestría en peritajes"},
    {id:7, nombre: "Maestría en educación especial"},
    {id:8, nombre: "Maestría en manejo de negacios"}
  ];

  private doctorado : any = [
    {id:9, nombre: "Doctorado en investigación"},
    {id:10, nombre: "Doctorado en tecnologías"}
  ];

  private gradoAcademico : any[] = [
    {id:1, nombreGrado:'Maestría'},
    {id:2, nombreGrado:'Licenciatura'},
    {id:3, nombreGrado:'Doctorado'}
  ];

  formulario = new  FormularioModel;

  ngOnInit() {
    /*this.formularioService.checaUsuario2()
    .subscribe( 
      (result) => {
        //console.log(result);
        this.usuario2 = result.idAlumno;
      }, 
      (error) => {
        console.log(<any>error);
      }

    ) ;*/

  }

  cambiarGradoAcademico(grado){
  //console.log(grado);
      document.getElementById('especialidad').setAttribute("value","0");
      if (grado == 2) {
        this.especialidad = this.licenciatura;
      } else if (grado == 1) {
        this.especialidad = this.maestria;
      } else if (grado == 3) {
        this.especialidad = this.doctorado;
      }else {
        this.especialidad = [];
      }
  }

  validarCuenta( matricula : String){
    //console.log(matricula);
    //validar el numero total de la matricula
    if ( matricula.length < 9){
      this.manejoErroresUsuario =  "El usuario es incorrecto";
    } else {
      this.formularioService.checarInscripcion(matricula) 
      .subscribe(
        (res:any[])=>{
        //this.crearArrego(res);
        //console.log(res);
        //var info = JSON.parse(JSON.stringify(res));
        //this.datos = res;          
        //console.log(info);
      },
      (error) => {
        //console.log('error', error.error.text);
        if (error.error.text === '400 BAD_REQUEST') {
          M.toast({html: 'El usuario ya existe', classes: 'rounded red'});
          this.manejoErroresUsuario =  "El usuario ya existe";
        } else {
          this.manejoErroresUsuario =  "El usuario es correcto";
        }
      }
      );
    }
  
  }

  verificarSemestre(semestre){
    if (semestre != 1) {
      this.manejoErroresSemestre = "No eres un Alumno de primer semestre, no te puedes registrar";
      M.toast({html: 'Semestre invalido', classes: 'rounded red'});
    } else {
      this.manejoErroresSemestre = "";
    }
    
  }
  guardar( form: NgForm  ) {
    //this.formularioService.checarUsuario() ;

    if (! (this.ValidateEmail(this.formulario.correo)) ) {
      M.toast({html: 'El correo electrónico es invalido', classes: 'rounded red'});
    } else if ( document.getElementById('validacionUsuario').innerHTML == " El usuario ya existe " 
      || document.getElementById('validacionUsuario').innerHTML == " El usuario es incorrecto ") {
      M.toast({html: 'El usuario ya existe', classes: 'rounded red'});
    } else if (this.formulario.semestre != "1") {
      M.toast({html: 'Semestre invalido', classes: 'rounded red'});
    } else {
      this.formularioService.crearAlumno( this.formulario )
      .subscribe(
        (result) => {
          var info = JSON.parse(JSON.stringify(result));
        }, 
        (error) => {
          console.log('error', error.error.text);
          if (error.error.text === '400 BAD_REQUEST') {
            console.log ("Se validará en el formulario")
            this.manejoErroresGeneral =  "El formulario tiene campos faltantes o los campos no son correctos";
          }
        }
        );
    }

    console.log(this.formulario);
    
   
  }

private ValidateEmail(email)
{ 
  var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  console.log(mailformat.test(String(email).toLocaleLowerCase()));
  return mailformat.test(String(email).toLocaleLowerCase());
}

}
