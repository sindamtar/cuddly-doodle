package presentation.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import persistence.Animal;
import presentation.mbeans.AnimalBean;

@FacesConverter("ac")
public class AnimalConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent arg1, String value) {
		if (value == null) {
			return null;
		}
		AnimalBean animalBean = context.getApplication().evaluateExpressionGet(context, "#{animalBean}",
				AnimalBean.class);
		Animal animal = animalBean.doFindAnimalByName(value);
		return animal;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		String string = null;
		if (value instanceof Animal) {
			string = ((Animal) value).getName();
		}
		return string;
	}

}
