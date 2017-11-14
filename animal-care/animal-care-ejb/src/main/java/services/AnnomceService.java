package services;

import java.util.Date;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.Animal;
import persistence.Annonce;
import persistence.User;


/**
 * Session Bean implementation class AnnomceService
 */
@Stateless
public class AnnomceService implements AnnomceServiceRemote, AnnomceServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public AnnomceService() {
	}

	@Override
	public void createAnnonce(User user, Animal animal, Date startDate, Date endtDate, String description,
			String place) {
		Annonce annonce = new Annonce(startDate, endtDate, place, description, user, animal);

		entityManager.merge(annonce);

	}

	

	

	
}
