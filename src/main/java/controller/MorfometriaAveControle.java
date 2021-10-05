
package controller;

import dao.DAO;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import model.animal.Animal;
import model.animal.Ave;
import model.animal.MorfometriaAves;

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.ave);
        hash = 89 * hash + Objects.hashCode(this.dao);
        hash = 89 * hash + (this.popupNovo ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.morfometria);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MorfometriaAveControle other = (MorfometriaAveControle) obj;
        if (this.popupNovo != other.popupNovo) {
            return false;
        }
        if (!Objects.equals(this.ave, other.ave)) {
            return false;
        }
        if (!Objects.equals(this.dao, other.dao)) {
            return false;
        }
        if (!Objects.equals(this.morfometria, other.morfometria)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MorfometriaAveControle{" + "ave=" + ave + ", dao=" + dao + ", popupNovo=" + popupNovo + ", morfometria=" + morfometria + '}';
    }

}
