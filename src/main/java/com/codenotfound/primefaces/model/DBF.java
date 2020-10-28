package com.codenotfound.primefaces.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "files_names")
public class DBF {

	@Id
	private String id;

	@NotEmpty
	private String fileName;

	@NotEmpty
	private String fileType;
	
	@NotEmpty
	private String account;


	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public DBF() {
		super();
	}

	public DBF(String id, String fileName, String fileType,String account) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.account = account;
	}

	
}
