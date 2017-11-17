package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Animal;
import persistence.Annonce;
import utilities.IGenericDAO;

@Remote
public interface AnimalServiceRemote extends IGenericDAO<Animal> {
	 List<Annonce> findAnnonceByAnimal(Animal animal);

		Animal createAnimal(Animal animal);
		void saveAnimal(Animal animal);
		void removeAnimal(Animal animal);

}