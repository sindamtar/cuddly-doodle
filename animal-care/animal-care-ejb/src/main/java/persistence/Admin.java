package persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Admin extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int adminLevel;

	public Admin() {
	}

	public Admin(String name, String login, String password, int adminLevel) {
		super(name, login, password);
		this.adminLevel = adminLevel;
	}

	@Column(name = "level")
	public Integer getAdminLevel() {
		return adminLevel;
	}

	public void setAdminLevel(Integer adminLevel) {
		this.adminLevel = adminLevel;
	}

}
