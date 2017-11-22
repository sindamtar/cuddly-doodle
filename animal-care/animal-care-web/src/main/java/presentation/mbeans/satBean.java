package presentation.mbeans;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import persistence.Annonce;

import services.AnnomceServiceLocal;



@ManagedBean
@ViewScoped
public class satBean {

	@EJB
	AnnomceServiceLocal csl ;
	
	private BarChartModel barModel;
	

	@PostConstruct
	public void init() {
	createBarModels();
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();

	ChartSeries stats = new ChartSeries();
stats.setLabel("");
	List<Annonce> ltp = csl.getPlaces();
	for (Annonce s : ltp) {
		Number number = csl.nbrAnnonceByPlaces(s.getPlace());
		  
			
		stats.set(s.getPlace(),number);
	}

	model.addSeries(stats);
	
		return model;

	}
		
	private void createBarModels() {
		createBarModel();

	}

	private void createBarModel() {
		barModel = initBarModel();

		barModel.setTitle("Bar Chart");
		barModel.setLegendPosition("ne");

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Animals");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("number of breeding");
		yAxis.setMin(0);
		yAxis.setMax(25);
	}
	
	
}
