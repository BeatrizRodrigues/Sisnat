/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.animal.Animal;
import modelo.animal.Observacao;

/**
 *
 * @author beeat
 */

@ViewScoped
@Named
public class ObservacaoControle implements Serializable {
    private Animal animal;
    private Observacao observacao;
    private boolean popupNovo;
    private DAO<Animal> dao;
    
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        animal = (Animal) ectx.getSessionMap().get("animal");
        dao = new DAO(Animal.class);
        observacao = new Observacao();
    }
    
    public void abrePopupNovo() {
        observacao = new Observacao();
        this.popupNovo = true;
    }
    
    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
    public void inserir(){
        observacao.setAnimal(animal);
        animal.getObservacoes().add(observacao);
        dao.alterar(animal);
        observacao = new Observacao();
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Observacao getObservacao() {
        return observacao;
    }

    public void setObservacao(Observacao observacao) {
        this.observacao = observacao;
    }

    public boolean isPopupNovo() {
        return popupNovo;
    }

    public void setPopupNovo(boolean popupNovo) {
        this.popupNovo = popupNovo;
    }

    public DAO<Animal> getDao() {
        return dao;
    }

    public void setDao(DAO<Animal> dao) {
        this.dao = dao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.animal);
        hash = 79 * hash + Objects.hashCode(this.observacao);
        hash = 79 * hash + (this.popupNovo ? 1 : 0);
        hash = 79 * hash + Objects.hashCode(this.dao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ObservacaoControle other = (ObservacaoControle) obj;
        if (this.popupNovo != other.popupNovo) {
            return false;
        }
        if (!Objects.equals(this.animal, other.animal)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.dao, other.dao)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "ObservacaoControle{" + "animal=" + animal + ", observacao=" + observacao + ", popupNovo=" + popupNovo + ", dao=" + dao + '}';
    }
    
    
}
