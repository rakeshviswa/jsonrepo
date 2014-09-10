package com.jsonstart;
import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;






@PersistenceCapable
public class ContactBean implements Serializable{
	
	
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private String ph_No;  
	@Persistent
	private String name;
	@Persistent
	private String email;
	@Persistent
	private String al_Email;
	@Persistent
	private String address;
	
    ContactBean(){}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public void setName(String name){this.name=name;}
	public void setPh_No(String ph_No){this.ph_No=ph_No;}
	public void setEmail(String email){this.email=email;}
	public void setAl_Email(String al_Email){this.al_Email=al_Email;}
	public void setAddress(String address){this.address=address;}
	public String getName(){return name;}
	public String getEmail(){return email;}
	public String getAl_Email(){return al_Email;}
	public String getAddress(){return address;}
	public String getPh_No(){return ph_No;}
}