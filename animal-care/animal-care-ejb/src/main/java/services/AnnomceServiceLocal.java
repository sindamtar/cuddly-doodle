package services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import persistence.Animal;
import persistence.Annonce;
import persistence.User;
import utilities.IGenericDAO;

@Local
public interface AnnomceServiceLocal extends IGenericDAO<Annonce>{
//	int plus ();
	void createAnnonce(User user, Animal animal, Date startDate, Date endtDate, String description, String place);
	
	void DeleteAnnonce(User user, Animal animal);
	
	List <Annonce>findAnnonceByAnimal(Animal animal);
	long nbrAnnonceByPlaces(String  place);
	 List<Annonce> getPlaces();
	List <Annonce>findAnnonceByMember(User user);

	void editAnnonce(User user, Animal animal, Date startDate, Date endtDate, String description, String place , int closed );
        
	void NbrOfClosed(Annonce annonce);
	
	List<Annonce> rechercherAllannoncesByDate(Date date);
 
	List<Annonce> searching(String place );

	Number CountAnimals();

	Number CountUsers();
	
	Number CountAnnonces();
	
 Map<String,Long> getAnimalByTown();
	 Annonce chercherAnnoncebyPlace(String place);

}
