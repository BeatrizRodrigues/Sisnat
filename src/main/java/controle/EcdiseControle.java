
package controle;

import dao.DAO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.animal.Animal;
import modelo.animal.Ecdise;

/**
 *
 * @author beeat
 */
@ViewScoped
@Named
public class EcdiseControle implements Serializable {
    private Animal animal;
    private Ecdise ecdise;
    private boolean popupNovo;
    private DAO<Animal> dao;
    
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        animal = (Animal) ectx.getSessionMap().get("animal");
        dao = new DAO(Animal.class);
        ecdise = new Ecdise();
    }
    
    public void abrePopupNovo() {
        ecdise = new Ecdise();
        this.popupNovo = true;
    }
    
    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
    public void inserir() {
        ecdise.setAnimal(animal);
        animal.getEcdise().add(ecdise);
        dao.alterar(animal);
        ecdise = new Ecdise();
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Ecdise getEcdise() {
        return ecdise;
    }

    public void setEcdise(Ecdise ecdise) {
        this.ecdise = ecdise;
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
