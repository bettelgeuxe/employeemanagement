package co.iotechnologies.bksqlemployeemanage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.iotechnologies.bksqlemployeemanage.exception.ResourceNotFoundException;
import co.iotechnologies.bksqlemployeemanage.model.Empleado;
import co.iotechnologies.bksqlemployeemanage.repository.EmpleadoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@GetMapping("/empleados")
	public List<Empleado> getAllEmpleados(){
		return empleadoRepository.findAll();
	}
	
	@PostMapping("/empleados")
	public Empleado crearEmpleado(@RequestBody Empleado empleado) {
		return empleadoRepository.save(empleado);
	}
	
	@GetMapping("/empleados/{id}")
	public ResponseEntity<Empleado> buscarEmpleadoPorId(@PathVariable Long id) {
		Empleado empleado = empleadoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empleado no existe con id:" + id));
		
		return ResponseEntity.ok(empleado); 
		
	}
	@PutMapping("/empleados/{id}")
	public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleadoDetalle){
		Empleado empleado = empleadoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empleado no existe con id:" + id));
		empleado.setFirstName(empleadoDetalle.getFirstName());
		empleado.setLastName(empleadoDetalle.getLastName());
		empleado.setEmailId(empleadoDetalle.getEmailId());
		
		Empleado actualizadoEmpleado = empleadoRepository.save(empleado);
		return ResponseEntity.ok(actualizadoEmpleado); 
		
	}
	

	
	
	
}
