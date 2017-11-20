package presentation.mbeans;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import persistence.Admin;
import persistence.Member;
import persistence.User;
import services.UserServicesLocal;

@ManagedBean
@SessionScoped
public class AuthentificationBean {

	@EJB
	private UserServicesLocal userServiceLocal;

	private User user = new User();

	private boolean loggedAsAdmin = false;
	private boolean loggedAsVisitor = false;
	private boolean loggedAsMember = false;

	public String doLogin() {
		
	
		System.err.println("sdjsdjujdsbds");
		
		String navto = "";
		User found = userServiceLocal.authenticate(user.getLogin(), user.getPassword());
		if (found != null) {
			user = found;
			if (found instanceof Admin) {
				loggedAsAdmin = true;
				navto = "/layout1?faces-redirect=true";
			}
			if (found instanceof Member) {
				loggedAsMember = true;
				navto = "/layout1?faces-redirect=true";
				
				

			} else {
				setLoggedAsVisitor(true);
				navto = "/layout?faces-redirect=true";
			}

		}
		return navto;
	}

	public UserServicesLocal getUserServiceLocal() {
		return userServiceLocal;
	}

	public void setUserServiceLocal(UserServicesLocal userServiceLocal) {
		this.userServiceLocal = userServiceLocal;
	}

	public String doLogout() {
		user = new User();
		return "/layout?faces-redirect=true";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedAsAdmin() {
		return loggedAsAdmin;
	}

	public void setLoggedAsAdmin(boolean loggedAsAdmin) {
		this.loggedAsAdmin = loggedAsAdmin;
	}

	public boolean isLoggedAsVisitor() {
		return loggedAsVisitor;
	}

	public void setLoggedAsVisitor(boolean loggedAsVisitor) {
		this.loggedAsVisitor = loggedAsVisitor;
	}

	public boolean isLoggedAsMember() {
		return loggedAsMember;
	}

	public void setLoggedAsMember(boolean loggedAsMember) {
		this.loggedAsMember = loggedAsMember;
	}

}