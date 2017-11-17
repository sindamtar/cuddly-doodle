package presentation.mbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import persistence.Animal;
import persistence.Annonce;
import persistence.User;
import services.AnimalServiceLocal;
import services.AnnomceServiceLocal;
import services.UserServicesLocal;

@ManagedBean
@ViewScoped
public class AnnonceBean {
	
	public List<Annonce> getAnnonces1() {
		return Annonces1;
	}

	public void setAnnonces1(List<Annonce> annonces1) {
		Annonces1 = annonces1;
	}

	public UserServicesLocal getUserServicesLocal() {
		return userServicesLocal;
	}

	public void setUserServicesLocal(UserServicesLocal userServicesLocal) {
		this.userServicesLocal = userServicesLocal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Animal getAnimal1() {
		return animal1;
	}

	public void setAnimal1(Animal animal1) {
		this.animal1 = animal1;
	}

	private Annonce annonce = new Annonce();
	private List<Annonce> Annonces = new ArrayList<>();
	private List<Annonce> Annonces1 = new ArrayList<>();
	private List<Annonce> AnnoncesBYUser = new ArrayList<>();
	private List<Annonce> AnnoncesBYAnimal = new ArrayList<>();
	@EJB
	private AnnomceServiceLocal AnnomceServiceLocal;
	private UserServicesLocal userServicesLocal;
	@EJB
	private AnimalServiceLocal animalServiceLocal;
	@ManagedProperty(value = "#{animalBean}")
	private AnimalBean animalBean;
	private Animal animalSelected = new Animal();
	private Animal animal = new Animal();
     private User user = new User();
     
     

	
	
	public Animal animal1 =new Animal();
	
	public Animal getAnimalSelected() {
		return animalSelected;
	}

	public void setAnimalSelected(Animal animalSelected) {
		this.animalSelected = animalSelected;
	}

	public AnimalBean getAnimalBean() {
		return animalBean;
	}

	public void setAnimalBean(AnimalBean animalBean) {
		this.animalBean = animalBean;
	}

	public void addAnnonce() {

		AnnomceServiceLocal.createAnnonce(authentificationBean.getUser(), animalSelected, annonce.getStartDate(),
				annonce.getEndDate(), annonce.getDescription(), annonce.getPlace());
//		System.out.println("sinda mtar");
//		user1.setId(3);
//		animal1.setId(1);
//		animal1.setName("hhssg");
//		animal1.setUser(user1);
//	AnnomceServiceLocal.createAnnonce(user1,animal1,new Date(),
//		 new Date(),"yhdhdsd", "esprit");

			
		
	}

	public String doNew() {
		return "AddAnnonce?faces-redirect=true";
	}

	@ManagedProperty(value = "#{authentificationBean}")
	private AuthentificationBean authentificationBean;

	@PostConstruct
	public void init() {
	Annonces1 = AnnomceServiceLocal.findAll();

		// endtDate, description, place);//AnnoncesBYUser =
		// AnnomceServiceLocal.findAnnonceByMember(authentificationBean.getUser());

		//user= userServicesLocal.find(1);
		
	//	animal = animalServiceLocal.findAnimalsByMember(user.getId());

	Annonces = AnnomceServiceLocal.findAnnonceByMember(authentificationBean.getUser());

		
	
	
		
	}

	public AnnomceServiceLocal getAnnomceServiceLocal() {
		return AnnomceServiceLocal;
	}

	public void setAnnomceServiceLocal(AnnomceServiceLocal annomceServiceLocal) {
		AnnomceServiceLocal = annomceServiceLocal;
	}

	public AnimalServiceLocal getAnimalServiceLocal() {
		return animalServiceLocal;
	}

	public void setAnimalServiceLocal(AnimalServiceLocal animalServiceLocal) {
		this.animalServiceLocal = animalServiceLocal;
	}

	public List<Annonce> getAnnonces() {
		return Annonces;
	}

	public void setAnnonces(List<Annonce> Annonces) {
		this.Annonces = Annonces;
	}

	public List<Annonce> getAnnoncesBYAnimal() {
		return AnnoncesBYAnimal;
	}

	public void setAnnoncesBYAnimal(List<Annonce> AnnoncesBYAnimal) {
		this.AnnoncesBYAnimal = AnnoncesBYAnimal;
	}

	public List<Annonce> getAnnoncesBYUser() {
		return AnnoncesBYUser;
	}

	public void setAnnoncesBYUser(List<Annonce> AnnoncesBYUser) {
		this.AnnoncesBYUser = AnnoncesBYUser;
	}

	public AnnomceServiceLocal getAnnonceServiceLocal() {
		return AnnomceServiceLocal;
	}

	public void setAnnonceServiceLocal(AnnomceServiceLocal AnnonceServiceLocal) {
		this.AnnomceServiceLocal = AnnonceServiceLocal;
	}

	public AuthentificationBean getAuthentificationBean() {
		return authentificationBean;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public void setAuthentificationBean(AuthentificationBean authentificationBean) {
		this.authentificationBean = authentificationBean;
	}

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

}
