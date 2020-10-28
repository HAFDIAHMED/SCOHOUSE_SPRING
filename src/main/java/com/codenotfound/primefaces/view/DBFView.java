package com.codenotfound.primefaces.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.primefaces.Context;
import com.codenotfound.primefaces.model.DBF;
import com.codenotfound.primefaces.repository.DBFRepository;
import com.codenotfound.primefaces.repository.DBFileRepository;


@Named
@ViewScoped
public class DBFView {
	
	  @Autowired
	  private DBFileRepository dbFileRepository;
	  
	  @Autowired
	  private DBFRepository dbFRepository;

	  private List<DBF> dbFs;
	  
	  private String selected;
	  
	  
	  
	  public String getSelected() {
		FacesContext context = FacesContext.getCurrentInstance();
		selected = (String) context.getExternalContext().getSessionMap().get("selected");
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public List<DBF> getDbFs() {
		return dbFs;
	}
	
	public List<DBF> prof() {
		FacesContext context = FacesContext.getCurrentInstance();
		String account = (String) context.getExternalContext().getSessionMap().get("idUser");
		init();
		List<DBF> list = new ArrayList<DBF>(); 
		for(DBF f:dbFs) {
			if(f.getAccount().equals(account)) {
				list.add(f);
			}
		}
		return list;
	}

	@PostConstruct
	  public void init() {
		  dbFs = dbFRepository.findAll();
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
	
	public void upload()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		String account = (String) context.getExternalContext().getSessionMap().get("idUser");
		Context.setUsername(account);
		redirect("upload.html");
	}
	
	public void select() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put("selected",this.selected);
		redirect("video.xhtml");
	}
	
	public void delete() {
		dbFileRepository.delete(selected);
		dbFRepository.delete(selected);
		redirect("upload.xhtml");
	}
	
	  

	}

