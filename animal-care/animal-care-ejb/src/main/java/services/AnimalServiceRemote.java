package services;

import javax.ejb.Remote;

import persistence.Animal;
import utilities.IGenericDAO;

@Remote
public interface AnimalServiceRemote extends IGenericDAO<Animal> {

}
