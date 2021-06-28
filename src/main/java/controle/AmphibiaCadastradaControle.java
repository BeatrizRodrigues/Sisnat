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
public class AmphibiaCadastradaControle implements Serializable{
    private Animal animal;
    private Amphibia amphibia;
    private DAO<Amphibia> dao;
    private MorfometriaAmphibia morfometria;
        
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        animal = (Animal) ectx.getSessionMap().get("animal");
        amphibia = (Amphibia) ectx.getSessionMap().get("amphibia");
        dao = new DAO(Amphibia.class);
    }
       
    public String alimentar(Animal animal){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        ectx.getSessionMap().put("animal", animal);
        return "/animal/alimentacao";
    }
    
    public String ecdise(Amphibia amphibia){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        ectx.getSessionMap().put("animal", animal);
        return "/animal/ecdiseAmphibia";
    }
    
    public String morfometria(Amphibia amphibia){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        ectx.getSessionMap().put("animal", animal);
        return "/animal/morfometriaAmphibia";
    }

    public Amphibia getAmphibia() {
        return amphibia;
    }

    public void setAmphibia(Amphibia amphibia) {
        this.amphibia = amphibia;
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

    public DAO<Amphibia> getDao() {
        return dao;
    }

    public void setDao(DAO<Amphibia> dao) {
        this.dao = dao;
    }
    
        
    
    
}
