package com.codenotfound.primefaces.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "participation")
public class Participation {
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
	
	@NotEmpty
    private String idAccount;
	 
	@NotEmpty
	private String idMatiere;
	
	private boolean Valid;
	
	
	
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isValid() {
		return Valid;
	}

	public void setValid(boolean valid) {
		Valid = valid;
	}

	public String getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(String idAccount) {
		this.idAccount = idAccount;
	}

	public String getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(String idMatiere) {
		this.idMatiere = idMatiere;
	}

	public Participation(String idAccount, String idMatiere, boolean valid) {
		super();
		this.idAccount = idAccount;
		this.idMatiere = idMatiere;
		this.Valid=valid;
	}

	public Participation() {
		super();
	}
	
	


	 
	 

}
