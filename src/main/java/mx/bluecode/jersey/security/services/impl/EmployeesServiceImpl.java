package mx.bluecode.jersey.security.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import mx.bluecode.jersey.security.model.Employee;
import mx.bluecode.jersey.security.services.EmployeeService;

/**
 * 
 * @author Julio Cesar Bolaños Palacios
 * @since 03/03/2017
 * @version 1.0
 */
@Singleton
public class EmployeesServiceImpl implements EmployeeService{
	
	/*
	 * (non-Javadoc)
	 * @see mx.bluecode.jersey.security.services.EmployeeService#findAll()
	 */
	@Override
	public List<Employee> findAll(){
		return createDummyEmployeeList();
	}

	
	/**
	 * 
	 * @return
	 */
	private List<Employee> createDummyEmployeeList() {
		List<Employee> data = new ArrayList<>();
		data.add(new Employee(1L, "Julio Cesar Bolaños Palacios"));
		data.add(new Employee(2L, "David Toledo Pateiro"));
		data.add(new Employee(3L, "Ernesto Espinoza Mendez"));
		data.add(new Employee(4L, "Mario Alberto Chavez"));
		data.add(new Employee(5L, "Iván García Martinez"));
		data.add(new Employee(6L, "Alán Alamillo"));
		return data;
	}

}
