package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.inject.*;
import entities.*;
import java.math.*;
import dao.*;

@ManagedBean(name="librarianBean")
@SessionScoped
public class LibrarianBean {
	private String name;
    private String salary;
    
    @Inject CheckBean checkBean;
    
    public LibrarianBean() {
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public boolean register() {
		
		return checkBean.isCorrectName() && checkBean.isCorrectPass();		
//		EntityManager em = EntityManagerUtils.getEntityManager();
//		
//		try {
//			Librarian librarian = new Librarian(name, new BigDecimal(salary));
//			em.getTransaction().begin();
//			em.persist(librarian);
//			em.flush();
//			em.getTransaction().commit();
//		} finally {
//			em.close();
//		}
//		return "done?faces-redirect=true";
	}
	
	
}
