package com.demo.ajax;

public class Person {
	private String name;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Person() {
		
	}
	
	public Person(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public void replace(Person p) {
		this.name = p.getName();
		this.email = p.getEmail();
	}
	
	public static Person createRandomPerson() {
		Double dName = Math.random();
		Double dEmail = Math.random();
		return new Person(dName.toString(), dEmail.toString());
	}
	
	@Override 
	public boolean equals(Object aPerson) {
		Person anPerson = (Person) aPerson;
		if ( anPerson.getName().equals(this.getName()) && 
			 anPerson.getEmail().equals(this.getEmail()) ) {
			return true;
			}
		return false;
	}
}
