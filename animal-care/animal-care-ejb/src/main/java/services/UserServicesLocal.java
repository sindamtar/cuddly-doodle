package services;

import javax.ejb.Local;

import persistence.User;
import utilities.IGenericDAO;

@Local
public interface UserServicesLocal extends IGenericDAO<User>{

}
