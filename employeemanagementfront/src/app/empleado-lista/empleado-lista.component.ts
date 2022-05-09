import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Empleado } from '../empleado.interface';
import { EmpleadoService } from '../empleado.service';

@Component({
  selector: 'app-empleado-lista',
  templateUrl: './empleado-lista.component.html',
  styleUrls: ['./empleado-lista.component.css']
})
export class EmpleadoListaComponent implements OnInit {

  empleados!: Empleado[];

  constructor(private empleadoservice: EmpleadoService, private router:Router ) { }

  ngOnInit(): void {
    this.getEmpleados();
  }

  private getEmpleados(){
    this.empleadoservice.getListaEmpleados().subscribe(data => {
      this.empleados = data;
    });
  }

  updateEmpleado(id:number){
    this.router.navigate(['actualizar-empleado', id]);
  }

}
