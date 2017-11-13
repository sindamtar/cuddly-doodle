package services;

import java.util.Date;

import javax.ejb.Local;

import persistence.Animal;
import persistence.User;

@Local
public interface AnnomceServiceLocal {
	void createAnnonce(User user, Animal animal, Date startDate, Date endtDate, String description, String place);
}
