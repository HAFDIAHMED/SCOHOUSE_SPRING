package com.codenotfound.primefaces.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.primefaces.model.Matiere;
import com.codenotfound.primefaces.repository.MatiereRepo;

@Named
@ViewScoped
public class MatiereView {
	
	  @Autowired
	  private MatiereRepo matiereRepo;

	  private List<Matiere> matieres;
	  
	  private String selected;
	  
	  private String name;
	  
	  private String niveau;
	  
	  private String niveauScolaire;
	  
	  private String semestre;
	  
	  private String prof;
	  
	  private String prix;
	  
	  private String page;  
	  
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

	public String getPage() {
		FacesContext context = FacesContext.getCurrentInstance();
		page = (String) context.getExternalContext().getSessionMap().get("matiere");
		return page;
	}

	public void setPage(String page) {
		FacesContext context = FacesContext.getCurrentInstance();
		this.page = page;
		context.getExternalContext().getSessionMap().put("matiere",page);
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

		public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
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
			  matieres = matiereRepo.findAll();
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
				matiereRepo.save(new Matiere(name,niveau,niveauScolaire,semestre,prof,prix));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			redirect("admin_matiere.xhtml");
		}
		
		public void delete() {
			matiereRepo.delete(selected);
			redirect("admin_matiere.xhtml");
		}
		
		public String nameById(String id) {
			return matiereRepo.findOne(id).getNom();
		}
		
		public String profById(String id) {
			return matiereRepo.findOne(id).getProf();
		}
		
		public String prixById(String id) {
			return matiereRepo.findOne(id).getPrix();
		}
		
		public String semestreById(String id) {
			return matiereRepo.findOne(id).getSemestre();
		}
		
		public String imageById() {
			String img = "";
			try {
				img = matiereRepo.findOne(selected).getImage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return img;
		}
		
		public String imageById(String id) {
			String img = "img/courses/c1.jpg";
			try {
				img = matiereRepo.findOne(id).getImage();
				if (img==null) {
					return "img/courses/c1.jpg";
				}
				else img = "/downloadFile/"+img;
			} catch (Exception e) {
				
			}
			if (img==null) {
				return "img/courses/c1.jpg";
			}
			return img;
		}
		
		
		public void image(){
			System.out.println(image);
			if (image!=null && !image.isEmpty()) {
				System.out.println(image);
				Matiere m = matiereRepo.findOne(selected);
				m.setImage(image);
				matiereRepo.save(m);
			}
			redirect("admin_matiere.xhtml");
		}

}
