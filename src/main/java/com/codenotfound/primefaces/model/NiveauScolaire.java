package com.codenotfound.primefaces.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "niveau_scolaire")
public class NiveauScolaire {
	
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
	 
    @NotEmpty
	private String nom;
	
    @NotEmpty
	private String niveau;
	
	

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
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

	public NiveauScolaire(String nom,String niveau) {
		super();
		this.nom = nom;
		this.niveau = niveau;
	}

	public NiveauScolaire() {
		super();
	}
	 
	 

}
