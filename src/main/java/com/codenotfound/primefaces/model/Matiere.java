package com.codenotfound.primefaces.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "matiere")
public class Matiere {
	
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
	 
    @NotEmpty
	private String nom;
	
    @NotEmpty
	private String niveau;
	
    @NotEmpty
	private String niveauScolaire;
	
    @NotEmpty
	private String semestre;
	
    @NotEmpty
	private String prof;
	
    @NotEmpty
	private String prix;
    
    private String image;
   

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getProf() {
		return prof;
	}

	public void setProf(String prof) {
		this.prof = prof;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getNiveauScolaire() {
		return niveauScolaire;
	}

	public void setNiveauScolaire(String niveauScolaire) {
		this.niveauScolaire = niveauScolaire;
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


	public Matiere(String nom, String niveau, String niveauScolaire,String semestre,String prof,String prix) {
		super();
		this.nom = nom;
		this.niveau = niveau;
		this.niveauScolaire = niveauScolaire;
		this.semestre = semestre;
		this.prof = prof;
		this.prix = prix;
	}

	public Matiere() {
		super();
	}
	 
	 

}
