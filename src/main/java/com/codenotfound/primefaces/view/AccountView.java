package com.codenotfound.primefaces.view;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.primefaces.model.Account;
import com.codenotfound.primefaces.model.Participation;
import com.codenotfound.primefaces.repository.AccountRepo;
import com.codenotfound.primefaces.repository.ParticipationRepo;

@Named
@ViewScoped
public class AccountView {
	
	  @Autowired
	  private AccountRepo accountRepo;
	  
	  @Autowired
	  private ParticipationRepo pRepo;

	  private List<Account> accounts;
	  
	  private String selected;
	  
	  private String nom;

	  private String prenom;
		
	  private String email;
	
	  private String phone;
		
	  private String password;
	  
	  private String repassword;
	  
	  public String errorMessage;
	  
	  private boolean loggedin;
	  
	  private boolean remember = false;
	  
	  private String type;
	  
	  private String userID;
	  
	  private Account account;
	  
	  private String avatar;
	  
		public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

		public Account getAccount() {
		account = accountRepo.findOne(getUserID());
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

		public String getUserID() {
		verifyLoginOnWelcomedummy();
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

		public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

		public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isLoggedin() {
		checkloginstatus();
		return loggedin;
	}

	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}

		@PostConstruct
		  public void init() {
			
			  accounts = accountRepo.findAll();
			  if (accounts.size()==0) {
				  accountRepo.save(new Account("admin", "admin", "admin","00000000", "admin","admin",true));
				  init();
			  }
			  
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
		

		public String nameById(String id) {
			Account acc = accountRepo.findOne(id);
			return(acc.getNom()+" "+acc.getPrenom());
		}
		
		public String nameById() {
			if (userID==null) return null;
			Account acc = accountRepo.findOne(userID);
			return(acc.getNom()+" "+acc.getPrenom());
		}
		
		public String mdpById(String id) {
			return accountRepo.findOne(id).getPassword();
		}
		
		public boolean admin() {
			if (userID==null) return false;
			return(accountRepo.findOne(userID).getType().equals("admin"));
		}
		
		public boolean prof() {
			if (userID==null) return false;
			return(accountRepo.findOne(userID).getType().equals("professeur"));
		}
		
		public void espaceAdmin() {
			checkloginstatus();
			if (!admin()) redirect("home.xhtml");
		}
		
		public void espaceProf() {
			checkloginstatus();
			if (!prof()) redirect("home.xhtml");
		}
		
		
		public void login() {
	        for (Account account:accounts) {
	            if (account.getEmail().equals(email) && account.getPassword().equals(password)) {
	            	if (!account.isValid()) {
	            		errorMessage = "Votre compte n'est pas valide, veuillez contacter l'administrateur";
	            		return;
	            	}	
	    			FacesContext context = FacesContext.getCurrentInstance();
	    			context.getExternalContext().getSessionMap().put("idUser",account.getId());
	    			redirect("home.xhtml");
	            	return;
	            }
	        }
	        errorMessage = "Email ou mot de passe invalid !";
		}
		
		public void signup() {
			if (password.equals(repassword)) {
						
				boolean existed = false;
				
		        for (Account account:accounts) {
		            if (account.getEmail().equals(email)) {
		            	errorMessage = "Email deja utilisé ! Veuillez contacter l'administrateur pour recuperer votre mot de passe";
		            	existed = true;
		            }
		        }
		        
		        if (!existed) {
				    try {
						accountRepo.save(new Account(nom,prenom,email,phone,password,type));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    redirect("index.xhtml");
		        }
				
			}
			else {
				errorMessage = "Vous n'avez pas bien retapé le mot de passe!";
			}
		}
		
		public void add() {
			boolean existed = false;
			
	        for (Account account:accounts) {
	            if (account.getEmail().equals(email)) {
	            	existed = true;
	            }
	        }
	        
	        if (!existed) {
			    try {
					accountRepo.save(new Account(nom,prenom,email,phone,password,type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    redirect("admin_account.xhtml");
	        }
		}
		
		
		public void edit() {
			
	        Account a = accountRepo.findOne(selected);
	        if (!nom.isEmpty()) a.setNom(nom);
	        if(!prenom.isEmpty()) a.setPrenom(prenom);
	        if (!email.isEmpty()) a.setEmail(email);
	        if(!phone.isEmpty()) a.setPhone(phone);
	        if(!type.isEmpty()) a.setType(type);
	        if(!password.isEmpty()) a.setPassword(password);
			accountRepo.save(a);
			redirect("admin_account.xhtml");
	        
		}
		
		public void delete() {
			accountRepo.delete(selected);
			redirect("admin_account.xhtml");
		}
		
		public void validate() {
			Account account = accountRepo.findOne(selected);
			account.setValid(true);
			accountRepo.save(account);
			redirect("admin_account.xhtml");
		}
		
		
		public void verifyLoginOnWelcomedummy()
		{
			this.errorMessage = "";
			FacesContext context = FacesContext.getCurrentInstance();
			this.setUserID((String) context.getExternalContext().getSessionMap().get("idUser"));			
		}
		
		public void checkloginstatus(){
			verifyLoginOnWelcomedummy();
			if	(userID == null || this.getUserID().equals("")) this.loggedin = false;
			else 												this.loggedin = true;
		}
		
		public void logout()
		{
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			try{
			TimeUnit.SECONDS.sleep(2);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			redirect("home.xhtml");
			
		}
		
		public void participer(){
			if(isLoggedin()) {
				FacesContext context = FacesContext.getCurrentInstance();
				Participation p = new Participation(getUserID(),(String) context.getExternalContext().getSessionMap().get("matiere"), admin()||prof() ? true : false);
				try {
					pRepo.save(p);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		public boolean participant() {
			if(!isLoggedin()) {return false;}
			FacesContext context = FacesContext.getCurrentInstance();
			for (Participation part:pRepo.findAll()) {
				if (getUserID().equals(part.getIdAccount())&&context.getExternalContext().getSessionMap().get("matiere").equals(part.getIdMatiere())) {
					return true;
				}
			}
			return false;
		}
		
		public boolean traitementPart() {
			if(!isLoggedin()) {return true;}
			FacesContext context = FacesContext.getCurrentInstance();
			String p = (String) context.getExternalContext().getSessionMap().get("matiere");
			for (Participation part:pRepo.findAll()) {
				if (getUserID().equals(part.getIdAccount())&&p.equals(part.getIdMatiere())) {
					return !pRepo.findOne(part.getId()).isValid();
				}
			}
			return true;
		}
		
		public boolean andd() {
			return traitementPart()&&participant();
		}
		
		public void editAccount() {
			
			getAccount();
			
			System.out.println("name : "+ nom.length());
			
			if (!nom.isEmpty()) {
				account.setNom(nom);
				System.out.println("name : "+ nom);
			}
			
			if (!prenom.isEmpty()) account.setPrenom(prenom);
			if (!email.isEmpty()) account.setEmail(email);
			if (!phone.isEmpty()) account.setPhone(phone);
			if (!password.isEmpty()) {
				if (!password.equals(repassword)) {
				}
				else {
					account.setPassword(password);
				}
			}
			accountRepo.save(account);
			redirect("gestion.xhtml");
		}
		
		public String avatarById(String id) {
			String img = "img/courses/c1.jpg";
			try {
				img = accountRepo.findOne(id).getAvatar();
				if (img==null) {
					return "img/avatar.png";
				}
				else img = "/downloadFile/"+img;
			} catch (Exception e) {
				
			}
			if (img==null) {
				return "img/avatar.png";
			}
			return img;
		}
		
		
		public void avatar(){
			if (avatar!=null && !avatar.isEmpty()) {
				Account m = accountRepo.findOne(selected);
				m.setAvatar(avatar);
				accountRepo.save(m);
			}
			redirect("admin_account.xhtml");
		}

		
		
		
		
}
