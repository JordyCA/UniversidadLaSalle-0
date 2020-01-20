import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormularioService } from 'src/app/services/formulario.service';
import { DatosusuarioModel } from 'src/app/Model/datosusuario.model';
import { NgForm } from '@angular/forms';
import M from 'materialize-css';

@Component({
  selector: 'app-datosusuario',
  templateUrl: './datosusuario.component.html',
  styleUrls: ['./datosusuario.component.css']
})
export class DatosusuarioComponent implements OnInit {

  constructor(private route: ActivatedRoute, private formularioService : FormularioService,  private router: Router) { }

  formularioDatosUsuario = new DatosusuarioModel();

  formularioDatosAlmacenados : any;

  private semestre: String = "";
  private nivelacademico: String = "";
  private especialidad: String = "";


  ngOnInit() {
    console.log();
    if (this.route.snapshot.paramMap.get('usuario') != '') {
      this.formularioService.informacionUsuario(this.route.snapshot.paramMap.get('usuario'))
        .subscribe( 
      (result) => {
        //console.log(result);
        this.formularioDatosAlmacenados = result;

        if (this.formularioDatosAlmacenados.semestre == "1") {
          console.log();
          this.semestre = this.formularioService.semestre[this.formularioDatosAlmacenados.semestre - 1]["semestre"];
        } else {
          this.semestre = "---";
        }
        this.nivelacademico = this.formularioService.gradoAcademico[this.formularioDatosAlmacenados.grado - 1]["nombreGrado"];
        if (this.formularioDatosAlmacenados.grado == "1") {
          this.especialidad = this.formularioService.maestria[this.formularioDatosAlmacenados.especialidad - 6]["nombre"];
        } else if (this.formularioDatosAlmacenados.grado == "2") {
          this.especialidad = this.formularioService.licenciatura[this.formularioDatosAlmacenados.especialidad - 1]["nombre"];
        } else if (this.formularioDatosAlmacenados.grado == "3") {
          this.especialidad = this.formularioService.doctorado[this.formularioDatosAlmacenados.especialidad - 9]["nombre"];
        }
        
        console.log(this.formularioDatosAlmacenados);
      }, 
      (error) => {
        console.log(<any>error);
      });
    } else {
      console.log("Error vacio");
    } 
  }

  actualizar(form: NgForm) {
    let seguir: boolean = true;

    this.formularioDatosUsuario.idMatricula = document.getElementById("usuario").innerHTML;

    if (this.formularioDatosUsuario.correo != null) {
      if (!(this.validateEmail(this.formularioDatosUsuario.correo)) ) {
        M.toast({html: 'El correo electrónico es invalido', classes: 'rounded red'});
        seguir = false;
      } else {
        seguir = true;
      }
    }
    if (this.formularioDatosUsuario.contrasena != null){
      if (this.formularioDatosUsuario.contrasena.length < 9){
        M.toast({html: 'La contraseña no tiene 9 cáracteres', classes: 'rounded red'});
        seguir = false;
      } else {
        seguir = true;
      }
    }

    if (seguir) {
      if (this.formularioDatosUsuario.nombre == null){
        this.formularioDatosUsuario.nombre = "ninguno";
      }
      
      if (this.formularioDatosUsuario.paterno == null){
        this.formularioDatosUsuario.paterno = "ninguno";
      } 
  
      if (this.formularioDatosUsuario.materno == null){
        this.formularioDatosUsuario.materno = "ninguno";
      }   

      if (this.formularioDatosUsuario.correo == null){
        this.formularioDatosUsuario.correo = "ninguno";
      }

      if (this.formularioDatosUsuario.correo == null){
        this.formularioDatosUsuario.correo = "ninguno";
      } 
      if (this.formularioDatosUsuario.contrasena == null){
        this.formularioDatosUsuario.contrasena = " ";
      }
      this.formularioService.actualizarInformacion(this.formularioDatosUsuario)
      .subscribe(
        (result) => {
          //console.log(result);
          this.router.navigate(['LaSalle/ingresoAlumnos']);
        },
        (error) => {
          //console.log(error);
          this.router.navigate(['LaSalle/ingresoAlumnos']);
        }
      );
    } /*else {
      this.router.navigate(['LaSalle/ingresoAlumnos']);
    }*/
  
    //console.log(this.formularioDatosUsuario);
  }

  salida(){
    this.router.navigate(['LaSalle/ingresoAlumnos']);
  }
  private validateEmail(email){ 
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    console.log(mailformat.test(String(email).toLocaleLowerCase()));
    return mailformat.test(String(email).toLocaleLowerCase());
  }
}
