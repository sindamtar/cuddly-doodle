package persistence;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Member
 *
 */
@Entity

public class Member extends User implements Serializable {

	private String typeOf;
	private static final long serialVersionUID = 1L;

	public Member() {
		super();
	}

	

	public Member(String name, String login, String password, String mail, long num, String typeOf) {
		super(name, login, password, mail, num);
		this.typeOf=typeOf;
	}



	public String getTypeOf() {
		return this.typeOf;
	}

	public void setTypeOf(String typeOf) {
		this.typeOf = typeOf;
	}

}
