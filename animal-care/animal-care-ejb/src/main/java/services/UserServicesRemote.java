package services;

import javax.ejb.Remote;

import persistence.User;
import utilities.IGenericDAO;

@Remote
public interface UserServicesRemote extends IGenericDAO<User> {

}
