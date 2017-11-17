package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Animal;
import persistence.User;
import services.AnimalServiceRemote;
import services.AnnomceServiceRemote;
import services.UserServicesRemote;

public class TestAddAnimals {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context
				.lookup("animal-care-ear/animal-care-ejb/UserServices!services.UserServicesRemote");
		AnimalServiceRemote animalServiceRemote = (AnimalServiceRemote) context
				.lookup("animal-care-ear/animal-care-ejb/AnimalService!services.AnimalServiceRemote");
		AnnomceServiceRemote annomceServiceRemote = (AnnomceServiceRemote) context
				.lookup("animal-care-ear/animal-care-ejb/AnnomceService!services.AnnomceServiceRemote");
		User user = userServicesRemote.findUserByLogin("sindam");
		Animal animal = new Animal();
		animal.setId(5);
		animal.setName("lara");
		animal.setUser(user);
		animal.setBreed("sss");
		animal.setAge(1);
		animal.setType("perg");

		Animal animal2 = new Animal();
		animal2.setId(6);
		animal2.setName("diego");
		animal2.setUser(user);
		animal2.setBreed("sss");
		animal2.setAge(1);
		animal2.setType("perg");

		animalServiceRemote.save(animal);
		animalServiceRemote.save(animal2);

	}

}
