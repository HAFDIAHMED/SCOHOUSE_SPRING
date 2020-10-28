package com.codenotfound.primefaces.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.primefaces.model.Semestre;
import com.codenotfound.primefaces.repository.SemestreRepo;

@Named
@ViewScoped
public class SemestreView {
	
	  @Autowired
	  private SemestreRepo semestreRepo;

	  private List<Semestre> semestres;
	  
	  private String selected;
	  
	  private String name;
	  
	  private String niveau;
	  
	  private String niveauScolaire;
	  
	  
	  
		public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public List<Semestre> getSemestres() {
		return semestres;
	}

	public void setSemestres(List<Semestre> semestres) {
		this.semestres = semestres;
	}

	public String getNiveauScolaire() {
		return niveauScolaire;
	}

	public void setNiveauScolaire(String niveauScolaire) {
		this.niveauScolaire = niveauScolaire;
	}

		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

		@PostConstruct
		  public void init() {
			  semestres = semestreRepo.findAll();
		  }
		  
		public void redirect(String page)
		{
			try{
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.getExternalContext().redirect(page);
				
			} catch(Exception e){
				System.out.println(e);
			}
		}
		
		public void add() {
			try {
				semestreRepo.save(new Semestre(name,niveau,niveauScolaire));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			redirect("admin_semestre.xhtml");
		}
		
		public void delete() {
			semestreRepo.delete(selected);
			redirect("admin_semestre.xhtml");
		}
		
		public String nameById(String id) {
			return semestreRepo.findOne(id).getNom();
		}

}
