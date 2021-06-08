package controle;

import dao.DAO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.animal.Animal;
import modelo.animal.MorfometriaReptilia;
import modelo.animal.Reptilia;

/**
 *
 * @author beeat
 */
@ViewScoped
@Named
public class MorfometriaReptiliaControle implements Serializable{
    private Reptilia reptilia;
    private DAO<Reptilia> dao;
    private boolean popupNovo;
    private MorfometriaReptilia morfometria;
    private Animal animal;
    
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        animal = (Animal) ectx.getSessionMap().get("animal");
        reptilia = (Reptilia) ectx.getSessionMap().get("reptilia");
        dao = new DAO(Reptilia.class);
        morfometria = new MorfometriaReptilia();
    }
    
    public void abrePopupNovo() {
        morfometria = new MorfometriaReptilia();
        this.popupNovo = true;
    }
    
    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
    public void inserir() {
        morfometria.setReptilia(reptilia);
        reptilia.getMorfometria().add(morfometria);
        dao.alterar(reptilia);
        morfometria = new MorfometriaReptilia();
    }

    public Reptilia getReptilia() {
        return reptilia;
    }

    public void setReptilia(Reptilia reptilia) {
        this.reptilia = reptilia;
    }

    public DAO<Reptilia> getDao() {
        return dao;
    }

    public void setDao(DAO<Reptilia> dao) {
        this.dao = dao;
    }

    public boolean isPopupNovo() {
        return popupNovo;
    }

    public void setPopupNovo(boolean popupNovo) {
        this.popupNovo = popupNovo;
    }

    public MorfometriaReptilia getMorfometria() {
        return morfometria;
    }

    public void setMorfometria(MorfometriaReptilia morfometria) {
        this.morfometria = morfometria;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    
}
