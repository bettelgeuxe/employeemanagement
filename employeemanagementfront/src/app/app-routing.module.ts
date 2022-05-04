import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmpleadoListaComponent } from './empleado-lista/empleado-lista.component';

const routes: Routes = [
  {path: 'empleados', component: EmpleadoListaComponent},
  {path: '', redirectTo: 'empleados', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
