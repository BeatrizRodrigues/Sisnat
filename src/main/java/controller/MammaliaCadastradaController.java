/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import model.animal.Animal;
import model.animal.Mammalia;

/**
 *
 * @author beeat
 */
@ViewScoped
@Named
public class MammaliaCadastradaController implements Serializable{
    private Mammalia animal;
    private DAO<Mammalia> dao;
        
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        animal = (Mammalia) ectx.getSessionMap().get("animal");
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
    
    public String morfometria(Mammalia mammalia){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        ectx.getSessionMap().put("animal", animal);
        return "/animal/morfometriaMammalia";
    }

    public Mammalia getAnimal() {
        return animal;
    }

    public void setAnimal(Mammalia animal) {
        this.animal = animal;
    }

    public DAO<Mammalia> getDao() {
        return dao;
    }

    public void setDao(DAO<Mammalia> dao) {
        this.dao = dao;
    }

    
}
