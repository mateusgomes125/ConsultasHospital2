package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Receituario;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named(value = "converterReceituario")
@RequestScoped
public class ConverteRceituario implements Serializable, Converter {

    @PersistenceContext(unitName = "ConsultasHospital-WebPU")
    protected EntityManager em;

    // converte da tela para o objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")){
            return null;
        }
        return em.find(Receituario.class, Integer.parseInt(string));
    }

    // converte do objeto para a tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t == null){
            return null;
        }
        Receituario obj = (Receituario) t;
        return obj.getId().toString();
    }
}