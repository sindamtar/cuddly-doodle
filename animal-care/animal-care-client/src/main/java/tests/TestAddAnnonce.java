package tests;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Animal;
import persistence.User;
import services.AnimalServiceRemote;
import services.AnnomceService;
import services.AnnomceServiceRemote;
import services.UserServicesRemote;

public class TestAddAnnonce {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context
				.lookup("animal-care-ear/animal-care-ejb/UserServices!services.UserServicesRemote");
		AnimalServiceRemote animalServiceRemote = (AnimalServiceRemote) context
				.lookup("animal-care-ear/animal-care-ejb/AnimalService!services.AnimalServiceRemote");
		AnnomceServiceRemote annomceServiceRemote = (AnnomceServiceRemote) context
				.lookup("animal-care-ear/animal-care-ejb/AnnomceService!services.AnnomceServiceRemote");

		User user = userServicesRemote.find(2);
		Animal animal = animalServiceRemote.find(5);
		User user3 = userServicesRemote.find(3);
		Animal animal2 = animalServiceRemote.find(6);
		annomceServiceRemote.createAnnonce(user, animal, new Date(), new Date(), "chat mezien", "dari");
		annomceServiceRemote.createAnnonce(user3, animal, new Date(), new Date(), "chat ", "esprit");
		annomceServiceRemote.createAnnonce(user3, animal2, new Date(), new Date(), "chien mezien", "tunis");
       
	}

}
