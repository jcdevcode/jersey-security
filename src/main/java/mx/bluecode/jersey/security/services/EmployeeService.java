package mx.bluecode.jersey.security.services;

import java.util.List;

import mx.bluecode.jersey.security.model.Employee;

/**
 * 
 * @author Julio Cesar Bolaños Palacios
 * @since 03/03/2017
 * @version 1.0
 */
public interface EmployeeService {
	
	/**
	 * Find all employees
	 * @return
	 */
	public List<Employee> findAll();
}
