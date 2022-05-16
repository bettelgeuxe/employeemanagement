import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActualizarEmpleadoComponent } from './actualizar-empleado/actualizar-empleado.component';
import { AuthGuardService } from './auth-guard.service';
import { CrearEmpleadoComponent } from './crear-empleado/crear-empleado.component';
import { DetalleEmpleadoComponent } from './detalle-empleado/detalle-empleado.component';
import { EmpleadoListaComponent } from './empleado-lista/empleado-lista.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';

const routes: Routes = [
  {path: 'empleados', component: EmpleadoListaComponent, canActivate:[AuthGuardService]},
  {path: 'crear-empleado', component: CrearEmpleadoComponent, canActivate:[AuthGuardService]},
  {path: '', redirectTo: 'empleados', pathMatch: 'full'},
  {path: 'actualizar-empleado/:id', component: ActualizarEmpleadoComponent, canActivate:[AuthGuardService]},
  {path: 'detalle-empleado/:id', component: DetalleEmpleadoComponent, canActivate:[AuthGuardService]},
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent, canActivate:[AuthGuardService]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
