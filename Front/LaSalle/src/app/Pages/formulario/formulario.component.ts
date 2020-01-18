import { Component, OnInit } from '@angular/core';
import { FormularioService } from '../../services/formulario.service';
import { NgForm } from '@angular/forms';
import { FormularioModel } from '../../Model/formulario.model';
import { Globals } from '../../Model/globals';
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
  public usuario2 : any;
  public manejoErrores :  string = ""; 

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

  validarCuenta(matricula){
    //console.log(matricula);
    this.formularioService.checarUsuario(matricula) 
        .subscribe(
          (res:any[])=>{
          //this.crearArrego(res);
          //console.log(res);
          //var info = JSON.parse(JSON.stringify(res));
          //this.datos = res;          
          //console.log(info);
        },
        (error) => {
          var info = JSON.parse(JSON.stringify(error));
          console.log(info.error.text);
          if (info.error.text === '400 BAD_REQUEST') {
            console.log ("Se validará en el formulario")
            this.manejoErrores =  "El usuario ya existe";
          } else {
            this.manejoErrores = "";
          }
        }
        );
  }

  verificarSemestre(semestre){
    if (semestre != 1) {
      this.manejoErrores = "Solamente si es de primer semestre se puede registrar";
    } else {
      this.manejoErrores = "";
    }
    
  }
  guardar( form: NgForm ) {
    //this.formularioService.checarUsuario() ;
    
    this.formularioService.crearAlumno( this.formulario )
    .subscribe(
      (result) => {
        var info = JSON.parse(JSON.stringify(result));
      }, 
      (error) => {
        var info = JSON.parse(JSON.stringify(error));
        console.log(info.error.text);
        if (info.error.text === '400 BAD_REQUEST') {
          console.log ("Se validará en el formulario")
          this.manejoErrores =  "El formulario tiene campos faltantes o los campos no son correctos";
        }
      }
      );
  }


  private crearArrego(objeto: object){
    var usuario = [];

    if (objeto === null) {
      this.datos = [];
    }
    

   var a = JSON.parse(JSON.stringify(objeto["idAlumno"]));
   this.datos = a;
   console.log(this.datos);

  }

}
