
package controle;

import dao.DAO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.animal.Animal;
import modelo.animal.Ave;
import modelo.animal.MorfometriaAves;

/**
 *
 * @author beeat
 */
@ViewScoped
@Named
public class MorfometriaAveControle implements Serializable {
    private Ave ave;
    private DAO<Ave> dao;
    private boolean popupNovo;
    private MorfometriaAves morfometria;
    private Animal animal;
    
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        ave = (Ave) ectx.getSessionMap().get("animal");
        dao = new DAO(Ave.class);
        morfometria = new MorfometriaAves();
    }
    
    public void abrePopupNovo() {
        morfometria = new MorfometriaAves();
        this.popupNovo = true;
    }
    
    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
    public void inserir() {
        morfometria.setAves(ave);
        ave.getMorfometria().add(morfometria);
        dao.alterar(ave);
        morfometria = new MorfometriaAves();
    }

    public Ave getAve() {
        return ave;
    }

    public void setAve(Ave ave) {
        this.ave = ave;
    }

    public DAO<Ave> getDao() {
        return dao;
    }

    public void setDao(DAO<Ave> dao) {
        this.dao = dao;
    }

    public boolean isPopupNovo() {
        return popupNovo;
    }

    public void setPopupNovo(boolean popupNovo) {
        this.popupNovo = popupNovo;
    }

    public MorfometriaAves getMorfometria() {
        return morfometria;
    }

    public void setMorfometria(MorfometriaAves morfometria) {
        this.morfometria = morfometria;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    
}
