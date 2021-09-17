package controller;

import dao.DAO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.animal.Animal;
import modelo.animal.Arachnida;

/**
 *
 * @author beeat
 */
@ViewScoped
@Named
public class ArachnidaCadastradaControle implements Serializable{
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
    
    public String ecdise(Arachnida arachnida){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        ectx.getSessionMap().put("animal", animal);
        return "/animal/ecdiseArachnida";
    }
    
    public String morfometria(Arachnida arachnida){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        ectx.getSessionMap().put("animal", animal);
        return "/animal/morfometriaArachnida";
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
