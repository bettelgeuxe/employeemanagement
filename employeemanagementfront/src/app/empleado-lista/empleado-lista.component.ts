import { Component, OnInit } from '@angular/core';
import { Empleado } from '../empleado';
import { EmpleadoService } from '../empleado.service';

@Component({
  selector: 'app-empleado-lista',
  templateUrl: './empleado-lista.component.html',
  styleUrls: ['./empleado-lista.component.css']
})
export class EmpleadoListaComponent implements OnInit {

  empleados!: Empleado[];

  constructor(private empleadoservice: EmpleadoService) { }

  ngOnInit(): void {
    this.getEmpleados();
  }

  private getEmpleados(){
    this.empleadoservice.getListaEmpleados().subscribe(data => {
      this.empleados = data;
    });
  }

}
