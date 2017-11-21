package presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import persistence.Animal;
import persistence.Annonce;
import services.AnimalServiceLocal;

@ManagedBean
@SessionScoped
public class AnimalBeans {

	private Animal animal = new Animal();
	private Animal animalSelected = new Animal();

	private List<Animal> animals = new ArrayList<>();
	private List<Animal> animalsBYUser = new ArrayList<>();
	private List<Annonce> AnnoncesBYAnimal = new ArrayList<>();

	@EJB
	private AnimalServiceLocal animalServiceLocal;
	
	@ManagedProperty(value = "#{authentificationBean}")
	private AuthentificationBean authentificationBean;

	@PostConstruct
	public void init() {
		animals = animalServiceLocal.findAll();
	   animalsBYUser = animalServiceLocal.findAnimalsByMember(authentificationBean.getUser());
     // animal=animalServiceLocal.createAnimal(animal);
    		 
	}

	
	public String addAnimal() {
		
        
		animalServiceLocal.create(animal,authentificationBean.getUser());
        
			return "/pages/listanimal?faces-redirect=true";
		
	}
	
	public String deleteAnimal(Animal ann) {

		
		animalServiceLocal.removeA(ann, authentificationBean.getUser());
		
		
		return "/pages/listanimal?faces-redirect=true";	
		
		
	}

	public void AfficheAnimal() {

		animalServiceLocal.save(animal);

			
		
	}

	
	public String UpdateAnimal(){
		animalServiceLocal.updateA(animal,authentificationBean.getUser());
		return "/pages/listanimal?faces-redirect=true";
	}

	
	public String NavigateUpdate(Animal c){
		return "/pages/UpdateAnimal?faces-redirect=true";
		
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

	public List<Annonce> getAnnoncesBYAnimal() {
		return AnnoncesBYAnimal;
	}

	public void setAnnoncesBYAnimal(List<Annonce> AnnoncesBYAnimal) {
		this.AnnoncesBYAnimal = AnnoncesBYAnimal;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Animal getAnimalSelected() {
		return animalSelected;
	}

	public void setAnimalSelected(Animal animalSelected) {
		this.animalSelected = animalSelected;
	}

	public Animal doFindAnimalByName(String value) {
		return animalServiceLocal.findAnimalByName(value);
	}

}
