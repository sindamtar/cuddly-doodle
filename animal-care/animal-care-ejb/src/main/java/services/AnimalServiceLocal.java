package services;

import java.util.List;

import javax.ejb.Local;

import persistence.Animal;
import persistence.Annonce;
import persistence.User;
import utilities.IGenericDAO;

@Local
public interface AnimalServiceLocal extends IGenericDAO<Animal> {
	
	
	Animal create(Animal animal,User user);
	

	void updateA (Animal animal ,User user); 
	
	void save(Animal animal);
	
	void removeA(Animal animal,User user);
	
	List<Animal> findAnimalsByMember(User user);

	List<Annonce> findAnnonceByAnimal(Animal animal);

	Animal findAnimalByName(String name);
}