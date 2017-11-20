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
	
	
	
	
	
	
	@Override
	public void editAnnonce(User user, Animal animal, Date startDate, Date endtDate, String description,
			String place, int closed)
	
	{
		
		Annonce annonce = new Annonce(startDate, endtDate, place, description,closed, user, animal);
		entityManager.merge(annonce);
	    
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
	
	
	
	
	


	
	
	
	
  public long nbrAnnonceByPlaces (String place){
		
		//return (int) em.createQuery("Select sum(c.nbrDownloads) from Cursus c where c.cathegory= :s").setParameter(1, cat).getSingleResult();	
		System.out.println("ssssssssssssss");
		long x= (long) entityManager.createQuery("Select sum(c.closed) from Annonce c where c.place= :s").setParameter("s", place).setFirstResult(0).setMaxResults(1).getSingleResult();	
		System.out.println("ss"+x);
		return x;
		
	}
	
	
	
	
	
	
  @Override
	public void NbrOfClosed(Annonce annonce) 
  {
	  
	 // Annonce annonce = new Annonce(startDate, endtDate, place, description,closed, user, animal);
		int Nb = annonce.getClosed();
		int newNb = Nb+1;
		annonce.setClosed(newNb);
		
		entityManager.merge(annonce);
		
	}
	

	@Override
  public List<Annonce> searching(String place ){
		
		return  entityManager.createQuery("select p from Annonce p where p.place= :param1",Annonce.class).setParameter("param1", place).getResultList();
		
	}

	@Override
	public List<Annonce> getPlaces() {
		 System.out.println("List Annonce");

			return entityManager.createQuery("Select l from Annonce l",Annonce.class).getResultList();

	}

	@Override
	public void UpdateLike(Annonce ct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateDislike(Annonce s) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

	@Override
	public List<Annonce> rechercherAllannoncesByDate(Date date) {
		TypedQuery<Annonce> querry = entityManager.createQuery("Select t from Annonce t where t.startDate =:date",Annonce.class);
		querry.setParameter("date", date);
		return querry.getResultList();
	}
	
	

	
	
	
	


	
}
