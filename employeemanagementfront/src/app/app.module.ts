import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmpleadoListaComponent } from './empleado-lista/empleado-lista.component';
import {HttpClientModule} from '@angular/common/http';
import { CrearEmpleadoComponent } from './crear-empleado/crear-empleado.component';

@NgModule({
  declarations: [
    AppComponent,
    EmpleadoListaComponent,
    CrearEmpleadoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }