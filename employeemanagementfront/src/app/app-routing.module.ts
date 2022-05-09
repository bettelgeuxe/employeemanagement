import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActualizarEmpleadoComponent } from './actualizar-empleado/actualizar-empleado.component';
import { CrearEmpleadoComponent } from './crear-empleado/crear-empleado.component';
import { DetalleEmpleadoComponent } from './detalle-empleado/detalle-empleado.component';
import { EmpleadoListaComponent } from './empleado-lista/empleado-lista.component';

const routes: Routes = [
  {path: 'empleados', component: EmpleadoListaComponent},
  {path: 'crear-empleado', component: CrearEmpleadoComponent},
  {path: '', redirectTo: 'empleados', pathMatch: 'full'},
  {path: 'actualizar-empleado/:id', component: ActualizarEmpleadoComponent},
  {path: 'detalle-empleado/:id', component: DetalleEmpleadoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
