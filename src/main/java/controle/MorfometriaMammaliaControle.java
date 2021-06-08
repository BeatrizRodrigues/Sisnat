package controle;

import dao.DAO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.animal.Animal;
import modelo.animal.Arachnida;
import modelo.animal.Mammalia;
import modelo.animal.MorfometriaMammalia;

/**
 *
 * @author beeat
 */
@ViewScoped
@Named
public class MorfometriaMammaliaControle implements Serializable {
    private Mammalia mammalia;
    private DAO<Mammalia> dao;
    private boolean popupNovo;
    private MorfometriaMammalia morfometria;
    private Animal animal;
    
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        animal = (Animal) ectx.getSessionMap().get("animal");
        mammalia = (Mammalia) ectx.getSessionMap().get("mammalia");
        dao = new DAO(Arachnida.class);
        morfometria = new MorfometriaMammalia();
    }
    
    public void abrePopupNovo() {
        morfometria = new MorfometriaMammalia();
        this.popupNovo = true;
    }
    
    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
    public void inserir() {
        morfometria.setMamalia(mammalia);
        mammalia.getMorfometria().add(morfometria);
        dao.alterar(mammalia);
        morfometria = new MorfometriaMammalia();
    }

    public Mammalia getMammalia() {
        return mammalia;
    }

    public void setMammalia(Mammalia mammalia) {
        this.mammalia = mammalia;
    }

    public DAO<Mammalia> getDao() {
        return dao;
    }

    public void setDao(DAO<Mammalia> dao) {
        this.dao = dao;
    }

    public boolean isPopupNovo() {
        return popupNovo;
    }

    public void setPopupNovo(boolean popupNovo) {
        this.popupNovo = popupNovo;
    }

    public MorfometriaMammalia getMorfometria() {
        return morfometria;
    }

    public void setMorfometria(MorfometriaMammalia morfometria) {
        this.morfometria = morfometria;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    
}
