package com.mb;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.facade.*;
import com.model.*;

@ManagedBean(name = "loginBean")
@SessionScoped()
public class LoginBean {
	private static String REGISTRATION = "registration";
	private static String WELCOME_READER = "/pages/public/welcomeReader?faces-redirect=true";
	private static String LOGOUT = "/pages/public/login.xhtml?faces-redirect=true";

	private String email;
	private String password;
	
	private Reader reader;
	private Librarian librarian;
	
	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

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

	public String login()
			throws IOException {
		try {
			getRequest().login(email, password);
			reader = readerFacade.findReaderByEmail(email);
			
		} catch (ServletException e) {
			return null;
		}
		
		if (reader == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Email not found", null));
			return null;
		}
		
		return WELCOME_READER;
	}

	public String startRegistration() {
		return REGISTRATION;
	}
	
	public static HttpServletRequest getRequest() {
		Object request = FacesContext.getCurrentInstance().getExternalContext().getRequest();
		return (HttpServletRequest) request;
	}
	
	public boolean isAuthenticated() {
		return getRequest().getUserPrincipal() != null;
	}
	
	public String Logout() throws ServletException {
		this.reader = null;
		this.librarian = null;
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		if (isAuthenticated()) {
			getRequest().logout();
		}
		return LOGOUT;
	}
}
