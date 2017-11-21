package tests;

import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Animal;
import persistence.Annonce;
import persistence.User;
import services.AnimalServiceRemote;
import services.AnnomceServiceRemote;
import services.UserServicesRemote;

public class Testadd {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context
				.lookup("animal-care-ear/animal-care-ejb/UserServices!services.UserServicesRemote");
		AnimalServiceRemote animalServiceRemote = (AnimalServiceRemote) context
				.lookup("animal-care-ear/animal-care-ejb/AnimalService!services.AnimalServiceRemote");
		AnnomceServiceRemote annomceServiceRemote = (AnnomceServiceRemote) context
				.lookup("animal-care-ear/animal-care-ejb/AnnomceService!services.AnnomceServiceRemote");
		
		
Number a = annomceServiceRemote.CountUsers();
System.out.println(a);


	}

}
