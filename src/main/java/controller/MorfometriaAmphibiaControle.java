package controller;

import dao.DAO;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import model.animal.Amphibia;
import model.animal.Animal;
import model.animal.MorfometriaAmphibia;

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
    
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        amphibia = (Amphibia) ectx.getSessionMap().get("animal");
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.amphibia);
        hash = 29 * hash + Objects.hashCode(this.dao);
        hash = 29 * hash + (this.popupNovo ? 1 : 0);
        hash = 29 * hash + Objects.hashCode(this.morfometria);
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
        final MorfometriaAmphibiaControle other = (MorfometriaAmphibiaControle) obj;
        if (this.popupNovo != other.popupNovo) {
            return false;
        }
        if (!Objects.equals(this.amphibia, other.amphibia)) {
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
        return "MorfometriaAmphibiaControle{" + "amphibia=" + amphibia + ", dao=" + dao + ", popupNovo=" + popupNovo + ", morfometria=" + morfometria + '}';
    }
    
       
    
}
