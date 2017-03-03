package mx.bluecode.jersey.security.model;

import java.io.Serializable;

/**
 * 
 * @author Julio Cesar Bolaños Palacios
 * @since 03/03/2017
 * @version 1.0
 */
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9167823429952835493L;
	private Long id;
	private String name;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Employee(){}
	public Employee(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	
}
