package com.codenotfound.primefaces.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "Avis")
public class Avis {
	
	@Id
    private String id;
	
	@NotEmpty
    private String idAccount;
	 
	@NotEmpty
	private String idSeance;

	private int rate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(String idAccount) {
		this.idAccount = idAccount;
	}

	public String getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(String idSeance) {
		this.idSeance = idSeance;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Avis(String idAccount, String idSeance, int rate) {
		super();
		this.idAccount = idAccount;
		this.idSeance = idSeance;
		this.rate = rate;
		this.id=idAccount+idSeance;
	}

	public Avis() {
		super();
	}
}
