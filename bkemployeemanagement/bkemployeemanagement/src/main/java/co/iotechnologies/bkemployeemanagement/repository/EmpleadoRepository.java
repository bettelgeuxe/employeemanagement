package co.iotechnologies.bkemployeemanagement.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.iotechnologies.bkemployeemanagement.model.Empleado;

public interface EmpleadoRepository extends MongoRepository<Empleado, String> {
	
	List<Empleado> findByCedula(Long cedula);
	
	void deleteByCedula(Long cedula);
}
