package com.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

@ManagedBean(name = "regBean")
@SessionScoped()
public class RegistrationBean {

	private String username;

	private String password;

	private String confirmpassword;

	private String email;

	private String confirmemail;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmemail() {
		return confirmemail;
	}

	public void setConfirmemail(String confirmemail) {
		this.confirmemail = confirmemail;
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public String addUser() {
		addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO,
				"User Registration Successful!!!", null));
		return "success";
	}
	
	public String startRegistration() {
		return "/pages/protected/user/registrationReader.xhtml?faces-redirect=true";
	}
}
