package com.codenotfound.primefaces.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.primefaces.model.Niveau;

import com.codenotfound.primefaces.repository.NiveauRepo;

@Named
@ViewScoped
public class NiveauView {
	
	  @Autowired
	  private NiveauRepo niveauRepo;

	  private List<Niveau> niveaux;
	  
	  private String selected;
	  
	  private String name;
	  
	  
	  
	  
	  
	  
		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		public List<Niveau> getNiveaux() {
		return niveaux;
	}



	public void setNiveaux(List<Niveau> niveaux) {
			this.niveaux = niveaux;
		}
	

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

		@PostConstruct
		  public void init() {
			  niveaux = niveauRepo.findAll();
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
				niveauRepo.save(new Niveau(name));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			redirect("admin_niveau.xhtml");
		}
		
		public void delete() {
			niveauRepo.delete(selected);
			redirect("admin_niveau.xhtml");
		}

		public String nameById(String id) {
			return niveauRepo.findOne(id).getNom();
		}
}
