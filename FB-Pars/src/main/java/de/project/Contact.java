package de.project;

import javafx.beans.property.SimpleStringProperty;

public class Contact {
	
	SimpleStringProperty firstname; 
	SimpleStringProperty lastname; 
	SimpleStringProperty username; 
	SimpleStringProperty FbId;

	public Contact(String firstname, String lastname, String username, String FbId) {
		super();
		this.firstname = new SimpleStringProperty(firstname);
		this.lastname = new SimpleStringProperty(lastname);
		this.username = new SimpleStringProperty(username);
		this.FbId = new SimpleStringProperty(FbId);
	}

	public String getFirstname() {
		return firstname.get();
	}

	public void setFirstname(String firstname) {
		this.firstname.set(firstname);
		
	}

	public String getLastname() {
		return lastname.get();
	}

	public void setLastname(String lastname) {
		this.lastname.set(lastname);
	}

	public String getUsername() {
		return username.get();
	}

	public void setUsername(String username) {
		this.username.set(username);
	}

	public String getFbId() {
		return FbId.get();
	}

	public void setFbId(String fbId) {
		FbId.set(fbId);
	}
	
	
	
	
}