package com.codenotfound.primefaces.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.primefaces.model.Cour;
import com.codenotfound.primefaces.model.Seance;
import com.codenotfound.primefaces.repository.CourRepo;
import com.codenotfound.primefaces.repository.MatiereRepo;
import com.codenotfound.primefaces.repository.SeanceRepo;

@Named
@ViewScoped
public class CourView {
	
	  @Autowired
	  private CourRepo courRepo;
	  
	  @Autowired
	  private SeanceRepo s;
	  
	  @Autowired
	  private MatiereRepo m;

	  private List<Cour> cours;
	  
	  private String selected;
	  
	  private String name;
	  
	  private String niveau;
	  
	  private String niveauScolaire;
	  
	  private String semestre;
	  
	  private String matiere;
	  
	  private String page;
	  
	  private String seance;
	  
	  
	  
	  public String getSeance() {
		  FacesContext context = FacesContext.getCurrentInstance();
		  seance = (String) context.getExternalContext().getSessionMap().get("seance");
		  if (seance == null) {
			 for (Seance seance:s.findAll()) {
				 if (seance.getCour().equals(getPage()) && seance.getNum()==1) {
					 this.seance = seance.getId();
					 break;
				 }
			 }
		  }
		  return seance;
	}
	  
	  
	  

	public void setSeance(String seance) {
		FacesContext context = FacesContext.getCurrentInstance();
		this.seance = seance;
		context.getExternalContext().getSessionMap().put("seance",seance);
	}

	public String getPage() {
			FacesContext context = FacesContext.getCurrentInstance();
			page = (String) context.getExternalContext().getSessionMap().get("cour");
			return page;
		}

	  public void setPage(String page) {
			FacesContext context = FacesContext.getCurrentInstance();
			this.page = page;
			context.getExternalContext().getSessionMap().put("cour",page);
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

	public List<Cour> getCours() {
		return cours;
	}

	public void setCours(List<Cour> cours) {
		this.cours = cours;
	}
	
	public List<Cour> prof() {
		FacesContext context = FacesContext.getCurrentInstance();
		String account = (String) context.getExternalContext().getSessionMap().get("idUser");
		init();
		List<Cour> list = new ArrayList<Cour>(); 
		for(Cour f:cours) {
			if(m.findOne(f.getMatiere()).getProf().equals(account)) {
				list.add(f);
			}
		}
		return list;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
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
			  cours = courRepo.findAll();
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
				courRepo.save(new Cour(name,niveau,niveauScolaire,semestre,matiere));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			redirect("admin_cour.xhtml");
		}
		
		public void addP() {
			try {
				courRepo.save(new Cour(name,niveau,niveauScolaire,semestre,matiere));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			redirect("prof_cour.xhtml");
		}
		
		public void delete() {
			courRepo.delete(selected);
			redirect("admin_cour.xhtml");
		}
		
		public void deleteP() {
			courRepo.delete(selected);
			redirect("prof_cour.xhtml");
		}
		
		public String nameById(String id) {
			return courRepo.findOne(id).getNom();
		}
		
		public String fileById(String id) {
			String result = null;
			try {
				result= s.findOne(id).getFile();
			} catch (Exception e) {
				redirect("home.xhtml");
			}
			return result;
		}
		
		
		
		  public void sui() {
			  Seance i = s.findOne(seance);
			  for(Seance seance:s.findAll()) {
				  if (seance.getCour().equals(i.getCour()) && seance.getNum() == i.getNum()+1) {
					  setSeance(seance.getId());
					  redirect("seance.xhtml");
					  break;
				  }
			  }
		  }
		  
		  public void pre() {
			  Seance i = s.findOne(seance);
			  for(Seance seance:s.findAll()) {
				  if (seance.getCour().equals(i.getCour()) && seance.getNum() == i.getNum()-1) {
					  setSeance(seance.getId());
					  redirect("seance.xhtml");
					  break;
				  }
			  }
		  }

}
