import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Empleado } from './empleado.interface';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {
  private baseURL='http://localhost:8080/api/v1/empleados';

  constructor(private httpClient:HttpClient) { }

  getListaEmpleados():Observable<Empleado[]>{
    return this.httpClient.get<Empleado[]>(`${this.baseURL}`);
  }

  crearEmpleado(empleado:Empleado):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, empleado);
  }

  //cambié tipo a string
  getEmpleadoById(id: string): Observable<Empleado>{
    return this.httpClient.get<Empleado>(`${this.baseURL}/id/${id}`);
  }

  getEmpleadoByCedula(cedula: number): Observable<Empleado>{
    return this.httpClient.get<Empleado>(`${this.baseURL}/cedula/${cedula}`);
  }


  updateEmpleado(id: string, empleado: Empleado):Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/id/${id}`, empleado);
  }


  deleteEmpleado(id: string): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/id/${id}`);
  }
}
