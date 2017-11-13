package services;

import javax.ejb.Stateless;

import persistence.Animal;
import utilities.GenericDAO;

/**
 * Session Bean implementation class AnimalService
 */
@Stateless
public class AnimalService extends GenericDAO<Animal> implements AnimalServiceRemote, AnimalServiceLocal {

	/**
	 * Default constructor.
	 */
	public AnimalService() {
		super(Animal.class);
	}

}
