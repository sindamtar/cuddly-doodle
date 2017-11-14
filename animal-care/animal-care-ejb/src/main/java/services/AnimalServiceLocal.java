package services;

import java.util.List;

import javax.ejb.Local;

import persistence.Animal;
import persistence.User;
import utilities.IGenericDAO;

@Local
public interface AnimalServiceLocal extends IGenericDAO<Animal> {
	List<Animal> findAnimalsByMember(User user);
}
