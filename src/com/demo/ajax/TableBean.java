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
	private boolean canAdd;
	private boolean canEdit;
	
	{	// initial table loading
		initPeople();
		for (int i = 0; i < 10; i++) {
			people.add(Person.createRandomPerson());
		}
		canAdd = false;
		canEdit = false;
	}
		
	public Person getCurrentPerson() {
		return currentPerson;
	}

	public void setCurrentPerson(Person currentPerson) {
		this.currentPerson = currentPerson;
	}

	public void setPeople(List<Person> people) {
		this.people = people;
	}

	public TableBean() {
	}
	
	public List<Person> getPeople() {
		return people;
	}
	
	public void add() {
		initPeople();
		people.add(currentPerson);
		canAdd = false;
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
		canAdd = false;
	}
	
	public void showAdd() {
		currentPerson = new Person("" , "");
		canAdd = true;
	}
	
	public boolean isCanAdd() {
		return canAdd;
	}

	public void setCanAdd(boolean isAdd) {
		this.canAdd = isAdd;
	}

	public boolean isCanEdit() {
		return canEdit;
	}

	public void setCanEdit(boolean isEdit) {
		this.canEdit = isEdit;
	}

	public void saveEdition() {
		for (Person p : people) {
			if (p.hashCode() == currentPerson.hashCode())
				p.replace(currentPerson);
		}
		canEdit = false;
	}
	
	public void cancel() {
		canEdit = false;
		canAdd = false;
	}
	
	public void edit(Person p) {
		this.currentPerson = p;	
		canEdit = true;
	}
	
	public void remove(Person p) {
		people.remove(p);
	}
}
