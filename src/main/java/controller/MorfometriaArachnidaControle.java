package controller;

import dao.DAO;
import java.io.Serializable;
import java.util.Objects;
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
    
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        arachnida = (Arachnida) ectx.getSessionMap().get("animal");
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.arachnida);
        hash = 67 * hash + Objects.hashCode(this.dao);
        hash = 67 * hash + (this.popupNovo ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.morfometria);
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
        final MorfometriaArachnidaControle other = (MorfometriaArachnidaControle) obj;
        if (this.popupNovo != other.popupNovo) {
            return false;
        }
        if (!Objects.equals(this.arachnida, other.arachnida)) {
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
        return "MorfometriaArachnidaControle{" + "arachnida=" + arachnida + ", dao=" + dao + ", popupNovo=" + popupNovo + ", morfometria=" + morfometria + '}';
    }
  
}
