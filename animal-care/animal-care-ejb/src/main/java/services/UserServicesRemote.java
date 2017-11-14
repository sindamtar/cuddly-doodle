package services;

import javax.ejb.Remote;

import persistence.User;
import utilities.IGenericDAO;

@Remote
public interface UserServicesRemote extends IGenericDAO<User> {
	User authenticate(String login, String password);

	User findUserByLogin(String login);

}
