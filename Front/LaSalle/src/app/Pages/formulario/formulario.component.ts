import { Component, OnInit } from '@angular/core';
import { FormularioService } from '../../services/formulario.service';
import { NgForm } from '@angular/forms';
import { FormularioModel } from '../../Model/formulario.model';
import { Formulario2Model } from '../../Model/formulario2.model';
import { analyzeNgModules } from '@angular/compiler';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css'],
  providers: [FormularioService]
})
export class FormularioComponent implements OnInit {
  private especialidad : any[] ;
  datos : any []; 
  datos2 : any[]; 
  usuario : any[];

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

  constructor( private formularioService : FormularioService ) { }

  ngOnInit() {
  }

  cambiarGradoAcademico(grado){
  console.log(grado);
      if (grado == 2) {
        this.especialidad = this.licenciatura;
      } else if (grado == 1) {
        this.especialidad = this.maestria;
      } else if (grado == 3) {
        this.especialidad = this.doctorado;
      }else {
        this.especialidad = [];
      }

      this.formularioService.checarUsuario() 
        .subscribe((res:any[])=>{
          //this.crearArrego(res);
          //console.log(res);
          //var info = JSON.parse(JSON.stringify(res));
          this.datos = res;
          
          //console.log(info);
        });
        /*.pipe(
          map( res => {
            var info = JSON.parse(JSON.stringify(res));
            this.datos = info;
            console.log(info);
          })
        )*/
        /*.subscribe((res) => {
          var info = JSON.parse(JSON.stringify(res));
          this.datos = info;
          })
        */
       /*.subscribe( res => {
         this.crearArrego (res)
       })
        ;*/
        this.formularioService.checaUsuario2()
        .subscribe(
          (result) => {
            this.datos2 = result;
        }, 
        (error) => {
          console.log(<any>error);
        });
      console.log(this.datos);

  }
  guardar( form: NgForm ) {
    this.formularioService.checarUsuario() ;
    
    //this.formularioService.crearAlumno( this.formulario );
    //this.formularioService.crearAlumno( this.formulario);
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
