package persistence;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Visitor
 *
 */
@Entity

public class Visitor extends User implements Serializable {

	private String cardId;
	private static final long serialVersionUID = 1L;

	public Visitor() {
		super();
	}

	public Visitor(String name, String login, String password, String cardId) {
		super(name, login, password);
		this.cardId = cardId;
	}

	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

}
