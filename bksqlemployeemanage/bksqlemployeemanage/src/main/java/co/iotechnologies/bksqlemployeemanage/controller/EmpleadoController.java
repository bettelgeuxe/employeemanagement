package co.iotechnologies.bksqlemployeemanage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.iotechnologies.bksqlemployeemanage.model.Empleado;
import co.iotechnologies.bksqlemployeemanage.repository.EmpleadoRepository;

@RestController
@RequestMapping("/api/v1/")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@GetMapping("/empleados")
	public List<Empleado> getAllEmpleados(){
		return empleadoRepository.findAll();
	}
	
	
	
}
