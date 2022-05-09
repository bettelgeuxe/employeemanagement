import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Empleado } from '../empleado.interface';
import { EmpleadoService } from '../empleado.service';

@Component({
  selector: 'app-detalle-empleado',
  templateUrl: './detalle-empleado.component.html',
  styleUrls: ['./detalle-empleado.component.css']
})
export class DetalleEmpleadoComponent implements OnInit {

  id!: number;
  empleado!: Empleado[];
  empleadobeta = {
    id: 0,
    firstName: '',
    lastName: '',
    emailId: ''
  }

  constructor(private route:ActivatedRoute, private empleadoService: EmpleadoService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.empleadoService.getEmpleadoById(this.id).subscribe(data=>{
      this.empleadobeta = data;
    }, error => console.log(error));
  }

}
