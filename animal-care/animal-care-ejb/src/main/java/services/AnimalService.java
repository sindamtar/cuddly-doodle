package services;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import persistence.Animal;
import persistence.Annonce;
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
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public List<Annonce> findAnnonceByAnimal(Animal animal) {

		List<Annonce> found = null;
		String jpql = "select u from Annonce u where u.animal=:animal";
		TypedQuery<Annonce> query = entityManager.createQuery(jpql, Annonce.class);
		query.setParameter("user", animal);
		try {
			found = query.getResultList();
		} catch (Exception ex) {
			Logger.getLogger(AnnomceService.class.getName()).log(Level.WARNING, "no such animal=" + animal);
		}
		return found;

	}

	@Override
	public Animal findAnimalByName(String name) {
		Animal found = null;
		String jpql = "select u from Animal u where u.name=:name";
		TypedQuery<Animal> query = entityManager.createQuery(jpql, Animal.class);
		query.setParameter("name", name);
		try {
			found = query.getSingleResult();
		} catch (Exception ex) {
			Logger.getLogger(AnnomceService.class.getName()).log(Level.WARNING, "no such animal=" + name);
		}
		return found;
	}

	@Override
	public Animal create(Animal animal,User user) 
	
	{
	    
	    animal.setUser(user);
		entityManager.persist(animal);
		return animal;
	}

	@Override
	public void save(Animal animal) {
		entityManager.merge(animal);
		
		
	}

	@Override
	public void removeA(Animal animal,User user) {
		
		animal.setUser(user);
		entityManager.remove(entityManager.merge(animal));
		
	}

	@Override
	public void updateA(Animal animal,User user) 
	{
		animal.setUser(user);
		entityManager.merge(animal);
		
	}

	@Override
	public void remove(Animal animal) {
		// TODO Auto-generated method stub
		
	}

	
	
	



}
