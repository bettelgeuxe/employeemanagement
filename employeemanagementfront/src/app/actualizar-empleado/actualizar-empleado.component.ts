import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Empleado } from '../empleado.interface';
//import { Empleado } from '../empleado.interface';
import { EmpleadoService } from '../empleado.service';

@Component({
  selector: 'app-actualizar-empleado',
  templateUrl: './actualizar-empleado.component.html',
  styleUrls: ['./actualizar-empleado.component.css']
})
export class ActualizarEmpleadoComponent implements OnInit {

  id!:string;
  empleados!: Empleado[];
  empleadobeta = {
    id!: '',
    cedula : 0,
    firstName: '',
    lastName: '',
    emailId: ''
  }


  constructor(private empleadoService: EmpleadoService, private route: ActivatedRoute, private router : Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.empleadoService.getEmpleadoById(this.id).subscribe(data =>
      {
        this.empleadobeta = data;
      }, error => console.log(error));

  }

  onSubmit(){
    this.empleadoService.updateEmpleado(this.id, this.empleadobeta).subscribe(data => {
      this.goToListaEmpleados();
    }, error => console.log(error));
  }

  goToListaEmpleados(){
    this.router.navigate(['/empleados'])

  }

}

