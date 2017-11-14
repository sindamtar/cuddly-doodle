package persistence;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable

public class AnnonceId implements Serializable {
	private int idUser;
	private int idAnimal;

	public AnnonceId() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAnimal;
		result = prime * result + idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnnonceId other = (AnnonceId) obj;
		if (idAnimal != other.idAnimal)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	public AnnonceId(int idUser, int idAnimal) {
		super();
		this.idUser = idUser;
		this.idAnimal = idAnimal;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getAnimal() {
		return idAnimal;
	}

	public void setAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

}
