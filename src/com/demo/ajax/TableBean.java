package com.demo.ajax;

import javax.faces.bean.*;
import java.util.*;

@ManagedBean(name = "table")
@SessionScoped
public class TableBean {
	private List<Person> people;
	private Person currentPerson;
		
	public Person getCurrentPerson() {
		return currentPerson;
	}

	public void setCurrentPerson(Person currentPerson) {
		this.currentPerson = currentPerson;
	}

	public void setPeople(List<Person> people) {
		this.people = people;
	}

	{
		initPeople();
		for (int i = 0; i < 10; i++) {
			people.add(Person.createRandomPerson());
		}
				
	}
	public TableBean() {
		initPeople();
	}
	
	public List<Person> getPeople() {
		return people;
	}
	
	public void add() {
		initPeople();
		people.add(currentPerson);
	}
	
	private void initPeople() {
		if (people == null) {
			people = new ArrayList<Person>();
		}
	}
	
	public void save() {
		initPeople();
		people.add(currentPerson);
	}
	
	public void cancel() {
		
	}
	
	public void edit(Person p) {
		this.currentPerson = p;		
	}
}
