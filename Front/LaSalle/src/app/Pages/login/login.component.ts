import { Component, OnInit } from '@angular/core';
import { FormularioService } from 'src/app/services/formulario.service';
import { NgForm } from '@angular/forms';
import { LoginModel } from 'src/app/Model/login.model';
import M from 'materialize-css';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private formularioService : FormularioService, private router: Router) { }

  ngOnInit() {
  }

  formularioLogin = new LoginModel;

  validacion( form:NgForm) {
    if (this.formularioLogin.usuario != "" && this.formularioLogin.contrasena != "") {
      this.formularioService.validarAcceso(this.formularioLogin.usuario, this.formularioLogin.contrasena)
      .subscribe (
        (result) => {
        }, 
        (error) => {
          if (error.error.text === '400 BAD_REQUEST') {
            M.toast({html: 'Datos incorrectos', classes: 'rounded red'});
          } else if (error.error.text === "200 OK"){
            console.log(this.formularioLogin.usuario);
            this.router.navigate(['LaSalle/ingresoAlumnos/Usuario/', this.formularioLogin.usuario]);
          }
        });
    } else {
      M.toast({html: 'Datos incorrectos', classes: 'rounded red'});
    }
  }

}
