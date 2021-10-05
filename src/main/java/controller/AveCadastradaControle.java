package controller;

import dao.DAO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import model.animal.Animal;
import model.animal.Ave;

/**
 *
 * @author beeat
 */
@ViewScoped
@Named
public class AveCadastradaControle implements Serializable{
    private Animal animal;
    private DAO<Animal> dao;
        
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
    
    public String morfometria(Ave ave){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        ectx.getSessionMap().put("animal", animal);
        return "/animal/morfometriaAve";
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public DAO<Animal> getDao() {
        return dao;
    }

    public void setDao(DAO<Animal> dao) {
        this.dao = dao;
    }
}
