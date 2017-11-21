package presentation.mbeans;



import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import persistence.Annonce;
import services.AnnomceServiceLocal;



@ManagedBean
@ViewScoped
public class StatBean {
	public Map<String, Long> m;
	private List<Annonce> mostActiveUsers;
	public List<Annonce> getMostActiveUsers() {
		return mostActiveUsers;
	}

	public void setMostActiveUsers(List<Annonce> mostActiveUsers) {
		this.mostActiveUsers = mostActiveUsers;
	}

	public AnnomceServiceLocal getService() {
		return service;
	}

	public void setService(AnnomceServiceLocal service) {
		this.service = service;
	}

	@EJB
	AnnomceServiceLocal service;
	public Map<String, Long> getM() {
		return m;
	}

	public void setM(Map<String, Long> m) {
		this.m = m;
	}
	
	public void init(){
		m = service.getAnimalByTown();
	}
//	public void loadMostActiveUsers(){
//		mostActiveUsers= service.getMostActiveUsers();
//	}
	public String getPieData(){
		Set<Entry<String, Long>> set = m.entrySet();
		String data="";
		Iterator<Entry<String, Long>> it = set.iterator();
		while (it.hasNext()){
			
			Entry<String, Long> e = it.next();
			data+="{ label :'"+e.getKey()+"', value:"+e.getValue()+"}";
			if (it.hasNext()){
				data+=",";
			}
		}
		return data;
	}

//	public List<Users> getMostActiveUsers() {
//		return mostActiveUsers;
//	}
//
//	public void setMostActiveUsers(List<Users> mostActiveUsers) {
//		this.mostActiveUsers = mostActiveUsers;
//	}
	
	public String getDate(Long millis){
		if(millis==null)
			millis=(long) 0;
		long second = (millis / 1000) % 60;
		long minute = (millis / (1000 * 60)) % 60;
		long hour = (millis / (1000 * 60 * 60)) % 24;
		long day= (millis / (1000 * 60 * 60)) / 24;
		return day+" days, "+hour+" hours, "+minute+" minutes and "+second+" seconds";
	}
	
}
