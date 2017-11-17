package services;

import java.util.List;

import javax.ejb.Local;

import persistence.Animal;
import persistence.Annonce;
import persistence.User;
import utilities.IGenericDAO;

@Local
public interface AnimalServiceLocal extends IGenericDAO<Animal> {
	
	
	Animal createAnimal(Animal animal);
	void saveAnimal(Animal animal);
	void removeAnimal(Animal animal);
	
	List<Animal> findAnimalsByMember(User user);

	List<Annonce> findAnnonceByAnimal(Animal animal);

	Animal findAnimalByName(String name);
}