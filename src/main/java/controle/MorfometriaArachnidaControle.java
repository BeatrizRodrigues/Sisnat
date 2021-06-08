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
import modelo.animal.MorfometriaArachnida;

/**
 *
 * @author beeat
 */
@ViewScoped
@Named
public class MorfometriaArachnidaControle implements Serializable{
    private Arachnida arachnida;
    private DAO<Arachnida> dao;
    private boolean popupNovo;
    private MorfometriaArachnida morfometria;
    private Animal animal;
    
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        animal = (Animal) ectx.getSessionMap().get("animal");
        arachnida = (Arachnida) ectx.getSessionMap().get("arachnida");
        dao = new DAO(Arachnida.class);
        morfometria = new MorfometriaArachnida();
    }
    
    public void abrePopupNovo() {
        morfometria = new MorfometriaArachnida();
        this.popupNovo = true;
    }
    
    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
    public void inserir() {
        morfometria.setArachnida(arachnida);
        arachnida.getMorfometria().add(morfometria);
        dao.alterar(arachnida);
        morfometria = new MorfometriaArachnida();
    }

    public Arachnida getArachnida() {
        return arachnida;
    }

    public void setArachnida(Arachnida arachnida) {
        this.arachnida = arachnida;
    }

    public DAO<Arachnida> getDao() {
        return dao;
    }

    public void setDao(DAO<Arachnida> dao) {
        this.dao = dao;
    }

    public boolean isPopupNovo() {
        return popupNovo;
    }

    public void setPopupNovo(boolean popupNovo) {
        this.popupNovo = popupNovo;
    }

    public MorfometriaArachnida getMorfometria() {
        return morfometria;
    }

    public void setMorfometria(MorfometriaArachnida morfometria) {
        this.morfometria = morfometria;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }  
}
