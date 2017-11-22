package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import persistence.Animal;
import persistence.Annonce;
import persistence.AnnonceId;
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
	public void DeleteAnnonce(Annonce an)  {
		
	
			
			entityManager.remove(entityManager.merge(an));
		
		
	}
	
	
	
	
	
	
	
//	public void sendEmail ()
//	{
//		TypedQuery<Annonce> query1 = entityManager.createQuery("select a from Annonce a ", Annonce.class);
//		
//		List<Annonce> listOffer = query1.getResultList();
//		
//		for (Annonce offer : listOffer)
//		{
//			
//		
//			
//			
//				System.out.println("id de offer : "+offer.getAnnonceId());
//			
//			
//			
//		}
//	}
//	
	
	
	
	

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
	
	

	
	
	
	
	
	
	
	
	
	public Map<String, Long> count(){
		Long q1 = (Long) entityManager.createQuery("Select count(*) from Animal pp").getSingleResult();
		Long q2 = (Long) entityManager.createQuery("Select count(*) from User c").getSingleResult();
		Long q3 = (Long) entityManager.createQuery("Select count(*) from Annonce c").getSingleResult();
		Map<String, Long> res = new HashMap<>();
		res.put("Animal", q1);
		res.put("User", q2);
		res.put("Annonce", q3);
		return res;
		
	}
	
	@Override
	public Number CountAnimals() {
		Number q1 = (Number) entityManager.createQuery("Select count(*) from Animal pp").getSingleResult();
		return q1;
	}

	@Override
	public Number CountUsers() {
		Number q1 = (Number) entityManager.createQuery("Select count(*) from User c").getSingleResult();
		return q1;
	}

	@Override
	public Number CountAnnonces() {
		Number q1 = (Number) entityManager.createQuery("Select count(*) from Annonce c").getSingleResult();
		return q1;
	}

	
	
	public Map<String,Long> getAnimalByTown(){
		Map<String, Long> result= new HashMap<String, Long>();
		String jpql = "SELECT DISTINCT place from Annonce";
		Query query = entityManager.createQuery(jpql);
		@SuppressWarnings("unchecked")
		ArrayList<String> towns= (ArrayList<String>) query.getResultList();
		
		
		
		Iterator<String> it = towns.iterator();
		while (it.hasNext()){
			String place= it.next();
			String jpql2= "SELECT Count(*) from Annonce u where u.place=:place";
			Query q2 = entityManager.createQuery(jpql2);
			q2.setParameter("place", place);
			result.put(place, (Long)q2.getSingleResult());
			
		}
		return result;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public AnimalService getAnimalServiceLocal() {
		return AnimalServiceLocal;
	}

	public void setAnimalServiceLocal(AnimalService animalServiceLocal) {
		AnimalServiceLocal = animalServiceLocal;
	}

	public UserServicesLocal getUserServicesLocal() {
		return UserServicesLocal;
	}

	public void setUserServicesLocal(UserServicesLocal userServicesLocal) {
		UserServicesLocal = userServicesLocal;
	}
	
	

	@Override
	public Annonce chercherAnnoncebyPlace(String place) {
		
		return entityManager.find(Annonce.class, place);
	}



	


	
}
