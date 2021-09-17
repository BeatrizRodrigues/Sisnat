package controller;

import dao.DAO;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
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
    
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        reptilia = (Reptilia) ectx.getSessionMap().get("animal");
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
        reptilia.getMorfometrias().add(morfometria);
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.reptilia);
        hash = 59 * hash + Objects.hashCode(this.dao);
        hash = 59 * hash + (this.popupNovo ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.morfometria);
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
        final MorfometriaReptiliaControle other = (MorfometriaReptiliaControle) obj;
        if (this.popupNovo != other.popupNovo) {
            return false;
        }
        if (!Objects.equals(this.reptilia, other.reptilia)) {
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
        return "MorfometriaReptiliaControle{" + "reptilia=" + reptilia + ", dao=" + dao + ", popupNovo=" + popupNovo + ", morfometria=" + morfometria + '}';
    }    
}
