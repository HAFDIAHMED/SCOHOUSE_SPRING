package com.codenotfound.primefaces.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.primefaces.model.NiveauScolaire;
import com.codenotfound.primefaces.repository.NiveauScolaireRepo;

@Named
@ViewScoped
public class NiveauScolaireView {
	
	  @Autowired
	  private NiveauScolaireRepo niveauScolaireRepo;

	  private List<NiveauScolaire> niveauxScolaire;
	  
	  private String selected;
	  
	  private String name;
	  
	  private String niveau;
	  
	  private String page;
	  
	  
	  
	  
		public String getPage() {
		FacesContext context = FacesContext.getCurrentInstance();
		page = (String) context.getExternalContext().getSessionMap().get("niveauScolaire");
		return page;
	}

	public void setPage(String page) {
		FacesContext context = FacesContext.getCurrentInstance();
		this.page = page;
		context.getExternalContext().getSessionMap().put("niveauScolaire",page);
	}

		public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public List<NiveauScolaire> getNiveauxScolaire() {
		return niveauxScolaire;
	}

	public void setNiveauxScolaire(List<NiveauScolaire> niveauxScolaire) {
		this.niveauxScolaire = niveauxScolaire;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

		@PostConstruct
		  public void init() {
			  niveauxScolaire = niveauScolaireRepo.findAll();
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
				niveauScolaireRepo.save(new NiveauScolaire(name,niveau));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			redirect("admin_niveau_scolaire.xhtml");
		}
		
		public void delete() {
			niveauScolaireRepo.delete(selected);
			redirect("admin_niveau_scolaire.xhtml");
		}
		
		public String nameById(String id) {
			return niveauScolaireRepo.findOne(id).getNom();
		}
		
		public String niveauById(String id) {
			return niveauScolaireRepo.findOne(id).getNiveau();
		}

}
