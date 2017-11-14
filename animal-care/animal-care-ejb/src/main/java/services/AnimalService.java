package services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import persistence.Animal;
import persistence.User;
import utilities.GenericDAO;

/**
 * Session Bean implementation class AnimalService
 */
@Stateless
public class AnimalService extends GenericDAO<Animal> implements AnimalServiceRemote, AnimalServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public AnimalService() {
		super(Animal.class);
	}

	@Override
	public List<Animal> findAnimalsByMember(User user) {
		
		
		
		List<Animal> found = null;
		String jpql = "select u from Animal u where u.user=:user";
		TypedQuery<Animal> query = entityManager.createQuery(jpql, Animal.class);
		query.setParameter("user", user);
		try {
			found = query.getResultList();
		} catch (Exception ex) {
			Logger.getLogger(AnimalService.class.getName()).log(Level.WARNING, "no such user=" + user);
		}
		return found;
	}

}
