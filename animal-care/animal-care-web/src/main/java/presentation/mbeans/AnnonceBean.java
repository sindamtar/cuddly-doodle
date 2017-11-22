package presentation.mbeans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import persistence.Animal;
import persistence.Annonce;
import persistence.User;
import services.AnimalServiceLocal;
import services.AnnomceService;
import services.AnnomceServiceLocal;
import services.UserServicesLocal;

@ManagedBean
@ViewScoped
public class AnnonceBean {
	@ManagedProperty(value = "#{animalBean}")
	private AnimalBean animalBean;

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

	private Annonce an;

	public Annonce getAn() {
		return an;
	}

	public void setAn(Annonce an) {
		this.an = an;
	}

	private Animal animal = new Animal();
	private User user = new User();

	private Annonce annonces = new Annonce(new Date(), new Date(), "dari", "chat mezien", 2, 0, user, animal);

	private Annonce annonce=new Annonce();
	private List<Annonce> Annonces = new ArrayList<>();
	private List<Annonce> Annonces1 = new ArrayList<>();
	private List<Annonce> Annonces2 = new ArrayList<>();
	private List<Annonce> AnnoncesBYUser = new ArrayList<>();
	private List<Annonce> AnnoncesBYAnimal = new ArrayList<>();
	@EJB
	private AnnomceServiceLocal AnnomceServiceLocal;
	private UserServicesLocal userServicesLocal;
	private String place = "";
	private List<Annonce> annoncess;

	public List<Annonce> getAnnonces2() {
		return Annonces2;
	}

	public void setAnnonces2(List<Annonce> annonces2) {
		Annonces2 = annonces2;
	}

	private List<Annonce> alltraining;

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public List<Annonce> getAnnoncess() {
		return annoncess;
	}

	public void setAnnoncess(List<Annonce> annoncess) {
		this.annoncess = annoncess;
	}

	public void setAnnonces(Annonce annonces) {
		this.annonces = annonces;
	}

	private PieChartModel pieModel1;
	@EJB
	private AnimalServiceLocal animalServiceLocal;

	private Animal animalSelected = new Animal();

	private AnnomceService ps;

	public Animal animal1 = new Animal();

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

	public String addAnnonce() {

		AnnomceServiceLocal.createAnnonce(authentificationBean.getUser(), animalSelected, annonce.getStartDate(),
				annonce.getEndDate(), annonce.getDescription(), annonce.getPlace());
		
		
		// System.out.println("sinda mtar");
		// user1.setId(3);
		// animal1.setId(1);
		// animal1.setName("hhssg");
		// animal1.setUser(user1);
		// AnnomceServiceLocal.createAnnonce(user1,animal1,new Date(),
		// new Date(),"yhdhdsd", "esprit");

		return "/pages/listAnnonce?faces-redirect=true";

	}

	public String confirmed() {

		AnnomceServiceLocal.NbrOfClosed(annonce);

		
		
		return "/EmailForm.jsf?faces-redirect=true";
	}

	public String doNew() {
		return "/pages/addAnnonce?faces-redirect=true";
	}

	public String doNewl() {
		return "/pages/listAnnonce?faces-redirect=true";
	}

	public String doNew2() {
		return "/AdminPages/addAnnonce?faces-redirect=true";
	}

	@ManagedProperty(value = "#{authentificationBean}")
	private AuthentificationBean authentificationBean;

	@PostConstruct
	public void init() {
		
		
		
		Annonces2 = AnnomceServiceLocal.findAll();

		// endtDate, description, place);//AnnoncesBYUser =
		// AnnomceServiceLocal.findAnnonceByMember(authentificationBean.getUser());

		// user= userServicesLocal.find(1);

		// animal = animalServiceLocal.findAnimalsByMember(user.getId());

		// Annonces =
		// AnnomceServiceLocal.findAnnonceByMember(authentificationBean.getUser());

		// createPieModels();

	}


public List<Annonce> getannonces() {

	
		if (place.equals("")) {
			Annonces = AnnomceServiceLocal.findAll();
		} else {
			Annonces = AnnomceServiceLocal.searching(place);
		}
		
	
	
		return Annonces;

	
 }

  public List<Annonce> getannoncesByMenmber() {
	  
	
		if (place.equals("")) {
			Annonces = AnnomceServiceLocal.findAnnonceByMember(authentificationBean.getUser());
		} else {
			Annonces = AnnomceServiceLocal.searching(place);
		}
		
	
		return Annonces;
	
  }

	private void createPieModels() {
		createPieModel1();

	}

	
	
	
	
public List<Annonce> getannonces4(){ 	
	
	//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	//String dateend = simpleDateFormat.format(an.getEndDate());
	//String dateNow = simpleDateFormat.format(new Date());
	Annonces=AnnomceServiceLocal.findAll();
	
	for (Annonce annonce : Annonces) {
		
//		boolean test = new Date().after(annonce.getEndDate());
//		System.out.println(test);
	
		
		if (new Date().after(annonce.getEndDate()))
		{
			
		
			
			//System.out.println(annonce);
			
			AnnomceServiceLocal.DeleteAnnonce(annonce);
			
			
		}
		Annonces=AnnomceServiceLocal.findAll();
		
	}
		
		
		Annonces=AnnomceServiceLocal.findAll();
		
		
		
		return Annonces;

	
		
	}
		
		
		
	

	
	
	
	
	
	private void createPieModel1() {
		pieModel1 = new PieChartModel();
		Number a = ps.CountAnimals();
		Number b = ps.CountAnnonces();
		Number c = ps.CountUsers();
		pieModel1.set("Animal", a);
		pieModel1.set("Annonce", b);
		pieModel1.set("User", c);

		pieModel1.setTitle("Users Participation");
		pieModel1.setLegendPosition("w");
	}

	public String NavigateToStat() {
		ps.count();
		return "/pages/statPage?faces-redirect=true";
	}

	public List<Annonce> getAlltraining() {
		return alltraining;
	}

	public void setAlltraining(List<Annonce> alltraining) {
		this.alltraining = alltraining;
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	public AnnomceService getPs() {
		return ps;
	}

	public void setPs(AnnomceService ps) {
		this.ps = ps;
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

	public String conf23(Annonce c) {

		return "/pages/conf?faces-redirect=true";
	}

	public List<Annonce> searching() {
		System.out.println(place);
		annoncess = AnnomceServiceLocal.searching(place);

		return annoncess;

	}

	public List<Annonce> rechercherAllannoncesByDate() {
		List<Annonce> lstTrainingByDate = AnnomceServiceLocal.rechercherAllannoncesByDate(an.getStartDate());
		if (lstTrainingByDate.isEmpty()) {
			return null;
		} else {
			return lstTrainingByDate;
		}

	}

	// public String quitter() {
	//
	// List <Annonce> ann=
	// AnnomceServiceLocal.findAnnonceByMember(authentificationBean.getUser());
	//
	// List <Animal> favory =
	// animalServiceLocal.findAnimalsByMember(authentificationBean.getUser());
	//
	// animalServiceLocal.delete(animal);
	//
	// return "Detail?selected=" + selectedOffer1.getIdOffer() +
	// "faces-redirect=true";
	// }
	//

	public String supprimer(Annonce an) {

		AnnomceServiceLocal.DeleteAnnonce(an);

		return "/AdminPages/listAnnonce?faces-redirect=true";

	}
	
	
	
		
	
	
	

}
