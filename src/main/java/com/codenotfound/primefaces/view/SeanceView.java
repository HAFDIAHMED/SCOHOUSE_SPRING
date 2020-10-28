package com.codenotfound.primefaces.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.primefaces.model.Avis;
import com.codenotfound.primefaces.model.Seance;
import com.codenotfound.primefaces.repository.AvisRepo;
import com.codenotfound.primefaces.repository.MatiereRepo;
import com.codenotfound.primefaces.repository.SeanceRepo;

@Named
@ViewScoped
public class SeanceView {
	
	  @Autowired
	  private SeanceRepo seanceRepo;
	  
	  @Autowired
	  private MatiereRepo m;
	  
	  @Autowired
	  private AvisRepo a;

	  private List<Seance> seances;
	  
	  private String selected;
	  
	  private String name;
	  
	  private String niveau;
	  
	  private String niveauScolaire;
	  
	  private String semestre;
	  
	  private String matiere;
	  
	  private String cour;
	  
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

	public List<Seance> getSeances() {
		return seances;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}
	
	public List<Seance> prof() {
		FacesContext context = FacesContext.getCurrentInstance();
		String account = (String) context.getExternalContext().getSessionMap().get("idUser");
		init();
		List<Seance> list = new ArrayList<Seance>(); 
		for(Seance f:seances) {
			if(m.findOne(f.getMatiere()).getProf().equals(account)) {
				list.add(f);
			}
		}
		return list;
	}
	
	public void vote(String idUser,String idSeance,int rate) {
		a.save(new Avis(idUser,idSeance,rate));
	}
	
	public String ratting(String idSeance) {
		int i=0;
		int s=0;
		for (Avis avi:a.findAll()) {
			if(avi.getIdSeance().equals(idSeance)){
				i++;
				s+=avi.getRate();
			}
		}
		if (i==0) return("Aucun vote");
		else return (((float)s/(float)i)*20+"% ("+i+")");
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public String getCour() {
		return cour;
	}

	public void setCour(String cour) {
		this.cour = cour;
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
			  seances = seanceRepo.findAll();
			  Collections.sort(seances, comp);
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
			int i = 1;
			for (Seance seance:seances) {
				if (seance.getCour().equals(cour)) i++;
			}
			System.out.println(name);
			System.out.println(niveau);
			System.out.println(niveauScolaire);
			System.out.println(semestre);

			System.out.println(matiere);
			System.out.println(cour);
			System.out.println(file);
			System.out.println(i);

			System.out.println(description);

			try {
				seanceRepo.save(new Seance(name,niveau,niveauScolaire,semestre,matiere,cour,i,file,description));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			redirect("admin_seance.xhtml");
		}
		
		public void addP() {
			int i = 1;
			for (Seance seance:seances) {
				if (seance.getCour().equals(cour)) i++;
			}
			try {
				seanceRepo.save(new Seance(name,niveau,niveauScolaire,semestre,matiere,cour,i,file,description));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			redirect("prof_seance.xhtml");
		}
		
		public void delete() {
			seanceRepo.delete(selected);
			redirect("admin_seance.xhtml");
		}
		
		public void deleteP() {
			seanceRepo.delete(selected);
			redirect("prof_seance.xhtml");
		}
		
		public String nameById(String id) {
			String result = null;
			try {
				result = seanceRepo.findOne(id).getNom();
			} catch (Exception e) {
				redirect("home.xhtml");
			}
			return result;
		}
		
		public String descById(String id) {
			String result = null;
			try {
				result = seanceRepo.findOne(id).getDescription();
			} catch (Exception e) {
				redirect("home.xhtml");
			}
			return result;
		}

		public static Comparator<Seance> comp = new Comparator<Seance>() {

			public int compare(Seance a, Seance b) {
			    return a.getNum() < b.getNum() ? -1
			         : a.getNum() > b.getNum() ? 1
			         : 0;
			}};
		
		
		

}
