package presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import persistence.Animal;
import services.AnimalServiceLocal;

@ManagedBean
@ViewScoped
public class AnimalBean {
	private List<Animal> animals = new ArrayList<>();
	private List<Animal> animalsBYUser = new ArrayList<>();
	@EJB
	private AnimalServiceLocal animalServiceLocal;
	@ManagedProperty(value = "#{authentificationBean}")
	private AuthentificationBean authentificationBean;

	@PostConstruct
	public void init() {
		animals = animalServiceLocal.findAll();
		animalsBYUser = animalServiceLocal.findAnimalsByMember(authentificationBean.getUser());
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public List<Animal> getAnimalsBYUser() {
		return animalsBYUser;
	}

	public void setAnimalsBYUser(List<Animal> animalsBYUser) {
		this.animalsBYUser = animalsBYUser;
	}

	public AnimalServiceLocal getAnimalServiceLocal() {
		return animalServiceLocal;
	}

	public void setAnimalServiceLocal(AnimalServiceLocal animalServiceLocal) {
		this.animalServiceLocal = animalServiceLocal;
	}

	public AuthentificationBean getAuthentificationBean() {
		return authentificationBean;
	}

	public void setAuthentificationBean(AuthentificationBean authentificationBean) {
		this.authentificationBean = authentificationBean;
	}

}
