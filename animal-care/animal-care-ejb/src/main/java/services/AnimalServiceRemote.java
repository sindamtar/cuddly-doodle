package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Animal;
import persistence.Annonce;
import persistence.User;
import utilities.IGenericDAO;

@Remote
public interface AnimalServiceRemote extends IGenericDAO<Animal> {
	 List<Annonce> findAnnonceByAnimal(Animal animal);

		Animal create(Animal animal, User user);
		void save(Animal animal);
		void remove(Animal animal);

}