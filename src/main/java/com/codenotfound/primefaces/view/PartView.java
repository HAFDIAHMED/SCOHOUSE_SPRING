package com.codenotfound.primefaces.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.primefaces.model.Participation;
import com.codenotfound.primefaces.repository.ParticipationRepo;

@Named
@ViewScoped
public class PartView {
	
	  @Autowired
	  private ParticipationRepo pRepo;

	  private List<Participation> participations;
	  
	  private String part;

		public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

		public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

		@PostConstruct
		  public void init() {
			  participations = pRepo.findAll();
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
		
		public void validate() {
			Participation parti = pRepo.findOne(part);
			parti.setValid(true);
			pRepo.save(parti);
			redirect("admin_part.xhtml");
		}
		  
}
