import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrearEmpleadoComponent } from './crear-empleado/crear-empleado.component';
import { EmpleadoListaComponent } from './empleado-lista/empleado-lista.component';

const routes: Routes = [
  {path: 'empleados', component: EmpleadoListaComponent},
  {path: 'crear-empleado', component: CrearEmpleadoComponent},
  {path: '', redirectTo: 'empleados', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
