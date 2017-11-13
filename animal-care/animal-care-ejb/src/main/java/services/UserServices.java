package services;

import javax.ejb.Stateless;

import persistence.User;
import utilities.GenericDAO;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices extends GenericDAO<User> implements UserServicesRemote, UserServicesLocal {

	/**
	 * Default constructor.
	 */
	public UserServices() {
		super(User.class);
	}

}
