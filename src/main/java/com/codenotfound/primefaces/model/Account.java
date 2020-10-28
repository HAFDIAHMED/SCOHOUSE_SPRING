package com.codenotfound.primefaces.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "account")
public class Account {
	
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
	
    @NotEmpty
	private String nom;
    
    @NotEmpty
	private String prenom;
	
    @NotEmpty
	private String email;
	
    @NotEmpty
	private String phone;
	
    @NotEmpty
	private String password;
	
    @NotEmpty
	private String type;
    
	private boolean valid;
	
	private String avatar;

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account(String nom, String prenom, String email, String phone, String password,String type) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.type = type;
		this.valid = false; 
	}
	
	public Account(String nom, String prenom, String email, String phone, String password,String type,boolean valid) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.type = type;
		this.valid = valid; 
	}

	public Account() {
		super();
	}
	
	
	
	 

}
