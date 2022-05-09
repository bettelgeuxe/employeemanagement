import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Empleado } from '../empleado.interface';
import { EmpleadoService } from '../empleado.service';

@Component({
  selector: 'app-crear-empleado',
  templateUrl: './crear-empleado.component.html',
  styleUrls: ['./crear-empleado.component.css']
})
export class CrearEmpleadoComponent implements OnInit {

  empleados!: Empleado[];
  empleadobeta = {
    id!: '',
    cedula : 0,
    firstName: '',
    lastName: '',
    emailId: ''
  }


  constructor(private empleadoservice: EmpleadoService, private router:Router) { }


  ngOnInit(): void {
  }

  onSubmit(){
    this.saveEmpleado();
  }

  saveEmpleado(){
    this.empleadoservice.crearEmpleado(this.empleadobeta).subscribe(data => {
      console.log(data);
      this.goToListaEmpleados();
    },
    error => console.log(error));
  }

  goToListaEmpleados(){
    this.router.navigate(['/empleados'])

  }

}
