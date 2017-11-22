package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import persistence.Animal;

import persistence.Annonce;
import persistence.User;
import utilities.IGenericDAO;


@Remote
public interface AnnomceServiceRemote  extends IGenericDAO<Annonce> {
	// int plus();
	void createAnnonce(User user, Animal animal, Date startDate, Date endtDate, String description, String place);
	void DeleteAnnonce(Annonce ann);
	 List<Annonce> findAnnonceByAnimal(Animal animal);
     
	 List<Annonce> findAnnonceByMember(User user);
	 void editAnnonce(User user, Animal animal, Date startDate, Date endtDate, String description, String place , int closed );

	 void UpdateLike(Annonce ct) ;
	 void UpdateDislike(Annonce s) ;
	 long nbrAnnonceByPlaces(String  place);
	 
	 void NbrOfClosed(Annonce annonce);
	 
	 List<Annonce> getPlaces();
	Number CountAnimals();
	Number CountUsers();
	Number CountAnnonces();

	
	
}
