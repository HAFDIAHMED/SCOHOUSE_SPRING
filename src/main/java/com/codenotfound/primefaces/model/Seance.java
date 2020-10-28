package com.codenotfound.primefaces.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "seance")
public class Seance {
	
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
	private String matiere;
	
    @NotEmpty
	private String cour;
	
    
	private int num;
	
    @NotEmpty
	private String file;
	
    
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getCour() {
		return cour;
	}

	public void setCour(String cour) {
		this.cour = cour;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
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


	public Seance(String nom, String niveau, String niveauScolaire,String semestre,String matiere,String cour,int num,String file,String description) {
		super();
		this.nom = nom;
		this.niveau = niveau;
		this.niveauScolaire = niveauScolaire;
		this.semestre = semestre;
		this.matiere = matiere;
		this.cour = cour;
		this.num = num;
		this.file = file;
		this.description = description;
	}

	public Seance() {
		super();
	}
	 
	 

}
