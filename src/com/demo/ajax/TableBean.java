package com.demo.ajax;

import javax.faces.bean.*;

import java.io.*;
import java.util.*;

@ManagedBean(name = "table")
@SessionScoped
public class TableBean implements Serializable {
	private static final long serialVersionUID = -8481463436338013136L;
	
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
		if (currentPerson == null) {
			currentPerson = new Person();
		}
	}
	
	public void save() {
		initPeople();
		people.add(currentPerson);
	}
	
	public void showAdd() {
		currentPerson = new Person("" , "");
	}
	
	public void saveEdition() {
		for (Person p : people) {
			if (p.hashCode() == currentPerson.hashCode())
				p.replace(currentPerson);
		}
		initPeople();
		people.add(currentPerson);
	}
	
	public void cancel() {
		
	}
	
	public void edit(Person p) {
		this.currentPerson = p;		
	}
	
	public void remove(Person p) {
		people.remove(p);
	}
}
