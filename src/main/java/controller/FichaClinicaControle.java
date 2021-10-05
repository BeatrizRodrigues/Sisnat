package controller;

import dao.DAO;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import model.animal.Animal;
import model.animal.FichaClinica;

@ViewScoped
@Named
public class FichaClinicaControle implements Serializable{
    private Animal animal;
    private FichaClinica ficha;
    private boolean popupNovo;
    private DAO<Animal> dao;
    
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        animal = (Animal) ectx.getSessionMap().get("animal");
        dao = new DAO(Animal.class);
        ficha = new FichaClinica();
    }
    
    public void abrePopupNovo() {
        ficha = new FichaClinica();
        this.popupNovo = true;
    }
    
    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
    public void inserir(){
        ficha.setAnimal(animal);
        animal.getFichas().add(ficha);
        dao.alterar(animal);
        ficha = new FichaClinica();
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public FichaClinica getFicha() {
        return ficha;
    }

    public void setFicha(FichaClinica ficha) {
        this.ficha = ficha;
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
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.animal);
        hash = 31 * hash + Objects.hashCode(this.ficha);
        hash = 31 * hash + (this.popupNovo ? 1 : 0);
        hash = 31 * hash + Objects.hashCode(this.dao);
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
        final FichaClinicaControle other = (FichaClinicaControle) obj;
        if (this.popupNovo != other.popupNovo) {
            return false;
        }
        if (!Objects.equals(this.animal, other.animal)) {
            return false;
        }
        if (!Objects.equals(this.ficha, other.ficha)) {
            return false;
        }
        if (!Objects.equals(this.dao, other.dao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FichaClinicaControle{" + "animal=" + animal + ", ficha=" + ficha + ", popupNovo=" + popupNovo + ", dao=" + dao + '}';
    }
    
    
}
