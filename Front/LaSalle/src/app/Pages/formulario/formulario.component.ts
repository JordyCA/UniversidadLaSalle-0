import { Component, OnInit } from '@angular/core';
import { FormularioService } from '../../services/formulario.service';
import { NgForm } from '@angular/forms';
import { FormularioModel } from '../../Model/formulario.model';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  formulario = new  FormularioModel;

  constructor( private formularioService : FormularioService ) { }

  ngOnInit() {
  }

  guardar( form: NgForm ) {

    //console.log(form);
    //console.log(this.formulario);
    //this.formularioService.crearAlumno( this.formulario );
    this.formularioService.crearAlumno( this.formulario);
  }
}
