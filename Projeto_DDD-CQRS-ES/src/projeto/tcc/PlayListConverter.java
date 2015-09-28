//package projeto.tcc;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ApplicationScoped;
//import javax.faces.bean.RequestScoped;
//import javax.faces.component.UIComponent;
//import javax.faces.context.FacesContext;
//import javax.faces.convert.Converter;
//import javax.faces.convert.ConverterException;
//import javax.faces.convert.FacesConverter;
//import javax.inject.Inject;
//import javax.inject.Named;
//
//import projeto.tcc.aplicacao.ServicoPlayListLeitura;
//import projeto.tcc.dominio.entidades.musica.PlayList;
//
//@FacesConverter("PlayListConverter")
//public class PlayListConverter implements Converter {
//	
//	@Inject	private ServicoPlayListLeitura servicoPlayListLeitura;
//	
//	public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
//	    if (modelValue == null) {
//	        return "";
//	    }
//
//	    if (modelValue instanceof PlayList) {
//	        return String.valueOf(((PlayList) modelValue).getAggregateID());
//	    } else {
//	        throw new ConverterException(new FacesMessage(modelValue + " is not a valid Warehouse"));
//	    }
//	}
//	
//	public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
//	    if (submittedValue == null || submittedValue.isEmpty()) {
//	        return null;
//	    }
//
//	    try {
//	        return servicoPlayListLeitura.buscarPlayList(submittedValue);
//	    } catch (NumberFormatException e) {
//	        throw new ConverterException(new FacesMessage(submittedValue + " is not a valid Warehouse ID"), e);
//	    }
//	}
//	
//}
