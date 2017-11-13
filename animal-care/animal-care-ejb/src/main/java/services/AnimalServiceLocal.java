package services;

import javax.ejb.Local;

import persistence.Animal;
import utilities.IGenericDAO;

@Local
public interface AnimalServiceLocal extends IGenericDAO<Animal> {

}
