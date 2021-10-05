/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.animal.EcdiseAmphibia;

/**
 *
 * @author beeat
 */
@ViewScoped
@Named
public class EcdiseAmphibiaControle implements Serializable  {
    private Amphibia amphibia;
    private EcdiseAmphibia ecdise;
    private boolean popupNovo;
    private DAO<Amphibia> dao;
    
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        amphibia = (Amphibia) ectx.getSessionMap().get("animal");
        dao = new DAO(Amphibia.class);
        ecdise = new EcdiseAmphibia();
    }
    
    public void abrePopupNovo() {
        ecdise = new EcdiseAmphibia();
        this.popupNovo = true;
    }
    
    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
    public void inserir() {
        ecdise.setAmphibia(amphibia);
        amphibia.getEcdises().add(ecdise);
        dao.alterar(amphibia);
        ecdise = new EcdiseAmphibia();
    }

    public Amphibia getAmphibia() {
        return amphibia;
    }

    public void setAmphibia(Amphibia amphibia) {
        this.amphibia = amphibia;
    }

    public EcdiseAmphibia getEcdise() {
        return ecdise;
    }

    public void setEcdise(EcdiseAmphibia ecdise) {
        this.ecdise = ecdise;
    }

    public boolean isPopupNovo() {
        return popupNovo;
    }

    public void setPopupNovo(boolean popupNovo) {
        this.popupNovo = popupNovo;
    }

    public DAO<Amphibia> getDao() {
        return dao;
    }

    public void setDao(DAO<Amphibia> dao) {
        this.dao = dao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.amphibia);
        hash = 83 * hash + Objects.hashCode(this.ecdise);
        hash = 83 * hash + (this.popupNovo ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.dao);
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
        final EcdiseAmphibiaControle other = (EcdiseAmphibiaControle) obj;
        if (this.popupNovo != other.popupNovo) {
            return false;
        }
        if (!Objects.equals(this.amphibia, other.amphibia)) {
            return false;
        }
        if (!Objects.equals(this.ecdise, other.ecdise)) {
            return false;
        }
        if (!Objects.equals(this.dao, other.dao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EcdiseAmphibiaControle{" + "amphibia=" + amphibia + ", ecdise=" + ecdise + ", popupNovo=" + popupNovo + ", dao=" + dao + '}';
    }
}
