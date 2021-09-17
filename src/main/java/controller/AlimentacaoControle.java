package controller;

import dao.DAO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.animal.Animal;
import modelo.animal.Alimentacao;

@ViewScoped
@Named
public class AlimentacaoControle implements Serializable {
    private Animal animal;
    private Alimentacao alimentacao;
    private boolean popupNovo;
    private DAO<Animal> dao;
        
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        animal = (Animal) ectx.getSessionMap().get("animal");
        dao = new DAO(Animal.class);
        alimentacao = new Alimentacao();
    }
    
    public void abrePopupNovo() {
        alimentacao = new Alimentacao();
        this.popupNovo = true;
    }
    
    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
    public void inserir() {
        alimentacao.setAnimal(animal);
        animal.getAlimentacoes().add(alimentacao);
        dao.alterar(animal);
        alimentacao = new Alimentacao();
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Alimentacao getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(Alimentacao alimentacao) {
        this.alimentacao = alimentacao;
    }

    public boolean isPopupNovo() {
        return popupNovo;
    }

    public void setPopupNovo(boolean popupNovo) {
        this.popupNovo = popupNovo;
    }
    
    
}
