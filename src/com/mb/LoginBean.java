package com.mb;

import java.awt.Frame;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.application.FacesMessage;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import com.facade.*;
import com.model.*;
import com.utils.*;

@ManagedBean(name = "loginBean")
@SessionScoped()
public class LoginBean {
	private static String REGISTRATION = "registration";
	private static String WELCOME_READER = "/pages/protected/user/welcomeReader?faces-redirect=true";

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

	public String login(ActionEvent actionEvent)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Reader reader = readerFacade.findReaderByEmail(email);
		
		if (reader == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Email not found", null));
			return null;
		}

		if (reader.getPassword().equals(password)) {
			return WELCOME_READER;
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Wrong password", null));
			return "login";
		}
	}

	public String startRegistration() {
		return REGISTRATION;
	}
	
	public static HttpServletRequest getRequest() {
		Object request = FacesContext.getCurrentInstance().getExternalContext().getRequest();
		return (HttpServletRequest) request;
	}
}
