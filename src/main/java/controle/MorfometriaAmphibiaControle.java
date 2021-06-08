package controle;

import dao.DAO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.animal.Amphibia;
import modelo.animal.Animal;
import modelo.animal.MorfometriaAmphibia;

/**
 *
 * @author beeat
 */

@ViewScoped
@Named
public class MorfometriaAmphibiaControle implements Serializable{
    private Amphibia amphibia;
    private DAO<Amphibia> dao;
    private boolean popupNovo;
    private MorfometriaAmphibia morfometria;
    private Animal animal;
    
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        animal = (Animal) ectx.getSessionMap().get("animal");
        amphibia = (Amphibia) ectx.getSessionMap().get("amphibia");
        dao = new DAO(Amphibia.class);
        morfometria = new MorfometriaAmphibia();
    }
    
    public void abrePopupNovo() {
        morfometria = new MorfometriaAmphibia();
        this.popupNovo = true;
    }
    
    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
    public void inserir() {
        morfometria.setAmphibia(amphibia);
        amphibia.getMorfometria().add(morfometria);
        dao.alterar(amphibia);
        morfometria = new MorfometriaAmphibia();
    }

    public Amphibia getAmphibia() {
        return amphibia;
    }

    public void setAmphibia(Amphibia amphibia) {
        this.amphibia = amphibia;
    }

    public DAO<Amphibia> getDao() {
        return dao;
    }

    public void setDao(DAO<Amphibia> dao) {
        this.dao = dao;
    }

    public boolean isPopupNovo() {
        return popupNovo;
    }

    public void setPopupNovo(boolean popupNovo) {
        this.popupNovo = popupNovo;
    }

    public MorfometriaAmphibia getMorfometria() {
        return morfometria;
    }

    public void setMorfometria(MorfometriaAmphibia morfometria) {
        this.morfometria = morfometria;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    
}
