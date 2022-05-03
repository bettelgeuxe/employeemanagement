package co.iotechnologies.bksqlemployeemanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.iotechnologies.bksqlemployeemanage.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	

}
