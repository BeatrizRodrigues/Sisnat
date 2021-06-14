package controle;

import dao.DAO;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import modelo.animal.Animal;

/**
 *
 * @author beeat
 */
public class AnimalCadasradoControle {
    private Animal animal;
    private DAO<Animal> dao;
    
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        animal = (Animal) ectx.getSessionMap().get("animal");
        dao = new DAO(Animal.class);
    }
}
