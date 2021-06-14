package controle;

import dao.DAO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.animal.Animal;
import modelo.animal.FichaClinica;

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
}
