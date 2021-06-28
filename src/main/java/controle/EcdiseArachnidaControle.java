package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.animal.Arachnida;
import modelo.animal.EcdiseArachnida;

/**
 *
 * @author beeat
 */
@ViewScoped
@Named
public class EcdiseArachnidaControle implements Serializable{
    private Arachnida arachnida;
    private EcdiseArachnida ecdise;
    private boolean popupNovo;
    private DAO<Arachnida> dao;
    
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        arachnida = (Arachnida) ectx.getSessionMap().get("animal");
        dao = new DAO(Arachnida.class);
        ecdise = new EcdiseArachnida();
    }
    
    public void abrePopupNovo() {
        ecdise = new EcdiseArachnida();
        this.popupNovo = true;
    }
    
    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
    public void inserir() {
        ecdise.setArachnida(arachnida);
        arachnida.getEcdises().add(ecdise);
        dao.alterar(arachnida);
        ecdise = new EcdiseArachnida();
    }

    public Arachnida getArachnida() {
        return arachnida;
    }

    public void setArachnida(Arachnida arachnida) {
        this.arachnida = arachnida;
    }

    public EcdiseArachnida getEcdise() {
        return ecdise;
    }

    public void setEcdise(EcdiseArachnida ecdise) {
        this.ecdise = ecdise;
    }

    public boolean isPopupNovo() {
        return popupNovo;
    }

    public void setPopupNovo(boolean popupNovo) {
        this.popupNovo = popupNovo;
    }

    public DAO<Arachnida> getDao() {
        return dao;
    }

    public void setDao(DAO<Arachnida> dao) {
        this.dao = dao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.arachnida);
        hash = 53 * hash + Objects.hashCode(this.ecdise);
        hash = 53 * hash + (this.popupNovo ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.dao);
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
        final EcdiseArachnidaControle other = (EcdiseArachnidaControle) obj;
        if (this.popupNovo != other.popupNovo) {
            return false;
        }
        if (!Objects.equals(this.arachnida, other.arachnida)) {
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
        return "EcdiseArachnidaControle{" + "arachnida=" + arachnida + ", ecdise=" + ecdise + ", popupNovo=" + popupNovo + ", dao=" + dao + '}';
    }
}
