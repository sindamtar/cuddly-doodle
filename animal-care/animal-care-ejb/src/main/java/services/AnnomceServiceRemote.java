package services;

import java.util.Date;

import javax.ejb.Remote;

import persistence.Animal;
import persistence.User;

@Remote
public interface AnnomceServiceRemote {
	void createAnnonce(User user, Animal animal, Date startDate, Date endtDate, String description, String place);
}
