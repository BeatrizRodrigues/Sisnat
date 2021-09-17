package controller;

import dao.DAO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.animal.Amphibia;
import modelo.animal.Animal;

/**
 *
 * @author beeat
 */
@ViewScoped
@Named
public class AmphibiaCadastradaControle implements Serializable{
    private Animal animal;
    private DAO<Amphibia> dao;
       
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        animal = (Animal) ectx.getSessionMap().get("animal");
        dao = new DAO(Animal.class);
    }
       
    public String alimentar(Animal animal){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        ectx.getSessionMap().put("animal", animal);
        return "/animal/alimentacao";
    }
    
    public String observacao(Animal animal){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        ectx.getSessionMap().put("animal", animal);
        return "/animal/observacao";
    }
    
    public String ficha (Animal animal){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        ectx.getSessionMap().put("animal", animal);
        return "/animal/fichaClinica";
    }
    
    public String ecdise(Amphibia amphibia){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        ectx.getSessionMap().put("animal", animal);
        return "/animal/ecdiseAmphibia";
    }
    
    public String morfometria(Amphibia amphibia){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        ectx.getSessionMap().put("animal", animal);
        return "/animal/morfometriaAmphibia";
    }
    
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public DAO<Amphibia> getDao() {
        return dao;
    }

    public void setDao(DAO<Amphibia> dao) {
        this.dao = dao;
    }
    
        
    
    
}
