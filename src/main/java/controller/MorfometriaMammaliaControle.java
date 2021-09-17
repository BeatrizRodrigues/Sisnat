package controller;

import dao.DAO;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.animal.Mammalia;
import modelo.animal.MorfometriaMammalia;

/**
 *
 * @author beeat
 */
@ViewScoped
@Named
public class MorfometriaMammaliaControle implements Serializable {
    private Mammalia mammalia;
    private DAO<Mammalia> dao;
    private boolean popupNovo;
    private MorfometriaMammalia morfometria;
    
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        mammalia = (Mammalia) ectx.getSessionMap().get("animal");
        dao = new DAO(Mammalia.class);
        morfometria = new MorfometriaMammalia();
    }
    
    public void abrePopupNovo() {
        morfometria = new MorfometriaMammalia();
        this.popupNovo = true;
    }
    
    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
    public void inserir() {
        morfometria.setMamalia(mammalia);
        mammalia.getMorfometria().add(morfometria);
        dao.alterar(mammalia);
        morfometria = new MorfometriaMammalia();
    }

    public Mammalia getMammalia() {
        return mammalia;
    }

    public void setMammalia(Mammalia mammalia) {
        this.mammalia = mammalia;
    }

    public DAO<Mammalia> getDao() {
        return dao;
    }

    public void setDao(DAO<Mammalia> dao) {
        this.dao = dao;
    }

    public boolean isPopupNovo() {
        return popupNovo;
    }

    public void setPopupNovo(boolean popupNovo) {
        this.popupNovo = popupNovo;
    }

    public MorfometriaMammalia getMorfometria() {
        return morfometria;
    }

    public void setMorfometria(MorfometriaMammalia morfometria) {
        this.morfometria = morfometria;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.mammalia);
        hash = 79 * hash + Objects.hashCode(this.dao);
        hash = 79 * hash + (this.popupNovo ? 1 : 0);
        hash = 79 * hash + Objects.hashCode(this.morfometria);
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
        final MorfometriaMammaliaControle other = (MorfometriaMammaliaControle) obj;
        if (this.popupNovo != other.popupNovo) {
            return false;
        }
        if (!Objects.equals(this.mammalia, other.mammalia)) {
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
        return "MorfometriaMammaliaControle{" + "mammalia=" + mammalia + ", dao=" + dao + ", popupNovo=" + popupNovo + ", morfometria=" + morfometria + '}';
    }
    
}
