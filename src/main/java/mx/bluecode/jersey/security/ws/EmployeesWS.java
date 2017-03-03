package mx.bluecode.jersey.security.ws;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import mx.bluecode.jersey.security.model.Employee;
import mx.bluecode.jersey.security.services.EmployeeService;

/**
 * 
 * @author Julio Cesar Bolaños Palacios
 * @since 03/03/2017
 * @version 1.0
 */
@Path("/employees")
@ManagedBean
public class EmployeesWS {
	
	@Inject
	private EmployeeService employeeService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
}
