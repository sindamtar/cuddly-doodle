package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Annonce
 *
 */
@Entity
@Table(name = "t_annonce")

public class Annonce implements Serializable {

	@EmbeddedId
	private AnnonceId annonceId;
	private Date startDate;
	private Date endDate;
	private String place;
	private String description;

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "idAnimal", referencedColumnName = "id", insertable = false, updatable = false)
	private Animal animal;
	private static final long serialVersionUID = 1L;

	public Annonce() {
		super();
	}

	public Annonce(Date startDate, Date endDate, String place, String description, User user, Animal animal) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.place = place;
		this.description = description;
		this.user = user;
		this.animal = animal;
		this.annonceId = new AnnonceId(user.getId(), animal.getId());
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}
