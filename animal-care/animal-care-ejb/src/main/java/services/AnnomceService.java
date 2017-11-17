package services;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import persistence.Animal;
import persistence.Annonce;
import persistence.User;
import utilities.GenericDAO;


/**
 * Session Bean implementation class AnnomceService
 */
@Stateless
public class AnnomceService extends GenericDAO<Annonce>  implements AnnomceServiceRemote, AnnomceServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public AnnomceService() {
		super(Annonce.class);
	}

	@Override
	public void createAnnonce(User user, Animal animal, Date startDate, Date endtDate, String description,
			String place) {
		Annonce annonce = new Annonce(startDate, endtDate, place, description, user, animal);

		entityManager.persist(annonce);

	}
	private AnimalService AnimalServiceLocal;
	private UserServicesLocal UserServicesLocal;

	@Override
	public void DeleteAnnonce(User user, Animal animal)  {
		
	
		
	}
	
	
	
	
	

	@Override
	public List<Annonce> findAnnonceByMember(User user) {
			
			
			
			List<Annonce> found = null;
			String jpql = "select u from Annonce u where u.user=:user";
			TypedQuery<Annonce> query = entityManager.createQuery(jpql, Annonce.class);
			query.setParameter("user", user);
			try {
				found = query.getResultList();
			} catch (Exception ex) {
				Logger.getLogger(AnnomceService.class.getName()).log(Level.WARNING, "no such user=" + user);
			}
			return found;
	
	}
	
	
	
	@Override
	public List<Annonce> findAnnonceByAnimal (Animal animal) {
			
			
			
			List<Annonce> found = null;
			String jpql = "select u from Annonce u where u.animal=:animal";
			TypedQuery<Annonce> query = entityManager.createQuery(jpql, Annonce.class);
			query.setParameter("animal", animal);
			try {
				found = query.getResultList();
			} catch (Exception ex) {
				Logger.getLogger(AnnomceService.class.getName()).log(Level.WARNING, "no such animal=" + animal);
			}
			return found;
	
	}
	
	
	
	

	


	

	
}
