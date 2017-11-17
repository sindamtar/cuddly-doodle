package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Admin;
import persistence.Member;
import persistence.Visitor;
import services.AnimalServiceRemote;
import services.AnnomceServiceRemote;
import services.UserServicesRemote;

public class TestAddUsers {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context
				.lookup("animal-care-ear/animal-care-ejb/UserServices!services.UserServicesRemote");
		AnimalServiceRemote animalServiceRemote = (AnimalServiceRemote) context
				.lookup("animal-care-ear/animal-care-ejb/AnimalService!services.AnimalServiceRemote");
		AnnomceServiceRemote annomceServiceRemote = (AnnomceServiceRemote) context
				.lookup("animal-care-ear/animal-care-ejb/AnnomceService!services.AnnomceServiceRemote");

		Admin admin = new Admin("daly", "d", "d","Daly@esprit.tn",2222,123);

		Visitor visitor = new Visitor("synda", "s", "s"," sinda.mtar@esprit.tn",12,"12");

		Member member = new Member("yasmine", "y", "y","yassmine@esprit.tn",3333, "VIP");

		userServicesRemote.save(admin);
		userServicesRemote.save(visitor);
		userServicesRemote.save(member);

	}

}
