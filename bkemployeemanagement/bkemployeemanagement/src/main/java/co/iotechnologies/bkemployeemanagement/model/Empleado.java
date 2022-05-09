package co.iotechnologies.bkemployeemanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "empleados")
public class Empleado {
	
	@Id
	private String id ;
	
	@Indexed(unique=true)
	private Long cedula;
	private String firstName;
	private String lastName;
	private String emailId;
	
	public Empleado() {
		
	}

	public Empleado(Long cedula, String firstName, String lastName, String emailId) {
		super();
		this.cedula = cedula;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
