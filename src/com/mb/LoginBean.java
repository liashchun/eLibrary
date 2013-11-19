package com.mb;

import javax.ejb.EJB;
import javax.faces.bean.*;

import com.facade.*;

@ManagedBean(name = "loginBean")
@SessionScoped()
public class LoginBean {
	private static String GO_TO_REGISTRATION_READER= 
			"/pages/protected/user/registrationReader.xhtml?faces-redirect=true";
	
	private String email;
	private String password;
	
	@EJB
	private ReaderFacade readerFacade;
	@EJB
	private LibrarianFacade librarianFacade;
	
	public LoginBean() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String login() {
				
	}

	public String startRegistration() {
		return GO_TO_REGISTRATION_READER;
	}
}
