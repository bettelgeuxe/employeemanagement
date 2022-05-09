package co.iotechnologies.bkemployeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.iotechnologies.bkemployeemanagement.model.Empleado;
import co.iotechnologies.bkemployeemanagement.repository.EmpleadoRepository;




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
	public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado) {
		try {
			Empleado _empleado = empleadoRepository.save(
					new Empleado(
							empleado.getCedula(),
							empleado.getFirstName(),
							empleado.getLastName(),
							empleado.getEmailId()));
			return new ResponseEntity<>(_empleado, HttpStatus.CREATED);
		} catch (DuplicateKeyException e) {
			return new ResponseEntity<>(null, HttpStatus.IM_USED);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/empleados/id/{id}")
	public ResponseEntity<Empleado> getEmpleadoById(@PathVariable("id") String id) {
		Optional<Empleado> empleadoData = empleadoRepository.findById(id);

		if (empleadoData.isPresent()) {
			return new ResponseEntity<>(empleadoData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/empleados/cedula/{cedula}")
	public ResponseEntity<Empleado> getEmpleadoByCedula(@PathVariable("cedula") Long cedula) {
		Empleado aux=empleadoRepository.findByCedula(cedula).get(0);
		Optional<Empleado> empleadoData =  Optional.of(aux);

		if (empleadoData.isPresent()) {
			return new ResponseEntity<>(empleadoData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/empleados/id/{id}")
	public ResponseEntity<Empleado> updateEmpleadoById(@PathVariable("id") String id, @RequestBody Empleado emplead) {
		Optional<Empleado> empleadoData = empleadoRepository.findById(id);

		if (empleadoData.isPresent()) {
			Empleado _empleado = empleadoData.get();
			_empleado.setCedula(emplead.getCedula());
			_empleado.setFirstName(emplead.getFirstName());
			_empleado.setLastName(emplead.getLastName());
			_empleado.setEmailId(emplead.getEmailId());
			
			return new ResponseEntity<>(empleadoRepository.save(_empleado), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping("/empleados/cedula/{cedula}")
	public ResponseEntity<Empleado> updateByCedula(@PathVariable("cedula") long cedula, @RequestBody Empleado emplead) {
		Empleado aux=empleadoRepository.findByCedula(cedula).get(0);
		Optional<Empleado> empleadoData =  Optional.of(aux);

		if (empleadoData.isPresent()) {
			Empleado _empleado = empleadoData.get();
			_empleado.setCedula(emplead.getCedula());
			_empleado.setFirstName(emplead.getFirstName());
			_empleado.setLastName(emplead.getLastName());
			_empleado.setEmailId(emplead.getEmailId());
			
			return new ResponseEntity<>(empleadoRepository.save(_empleado), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/empleados/id/{id}")
	public ResponseEntity<HttpStatus> deleteEmpleadoById(@PathVariable("id") String id) {
		try {
			empleadoRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
