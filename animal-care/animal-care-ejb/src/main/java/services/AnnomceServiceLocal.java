package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import persistence.Animal;
import persistence.Annonce;
import persistence.User;
import utilities.IGenericDAO;

@Local
public interface AnnomceServiceLocal extends IGenericDAO<Annonce>{
	
	void createAnnonce(User user, Animal animal, Date startDate, Date endtDate, String description, String place);
	
	void DeleteAnnonce(User user, Animal animal);
	
	List <Annonce>findAnnonceByAnimal(Animal animal);

	List <Annonce>findAnnonceByMember(User user);

}
