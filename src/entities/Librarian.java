package entities;

import javax.persistence.*;
import java.math.*;
import java.io.*;

@Entity 
@Table(name = "LIBRARIAN")
public class Librarian implements Serializable{
	private static final long serialVersionUID = 6494023960405671535L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID") 
	private int id;
	
	@Column(name = "name")   
	private String name;
	
	@Column(name = "salary") 
	private BigDecimal salary;
	
	protected Librarian() {}
	
	public Librarian(int id, String name, BigDecimal salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public Librarian(String name, BigDecimal salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public Librarian(String name, String salary) {
		this.name = name;
		this.salary = new BigDecimal(salary);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
}
