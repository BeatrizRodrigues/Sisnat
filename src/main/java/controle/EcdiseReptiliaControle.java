package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.animal.EcdiseReptilia;
import modelo.animal.Reptilia;

/**
 *
 * @author beeat
 */
@ViewScoped
@Named
public class EcdiseReptiliaControle implements Serializable{
    private Reptilia reptilia;
    private EcdiseReptilia ecdise;
    private boolean popupNovo;
    private DAO<Reptilia> dao;
    
    @PostConstruct
    public void inicializar(){         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        reptilia = (Reptilia) ectx.getSessionMap().get("animal");
        dao = new DAO(Reptilia.class);
        ecdise = new EcdiseReptilia();
    }
    
    public void abrePopupNovo() {
        ecdise = new EcdiseReptilia();
        this.popupNovo = true;
    }
    
    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
    public void inserir() {
        ecdise.setReptilia(reptilia);
        reptilia.getEcdises().add(ecdise);
        dao.alterar(reptilia);
        ecdise = new EcdiseReptilia();
    }

    public Reptilia getReptilia() {
        return reptilia;
    }

    public void setReptilia(Reptilia reptilia) {
        this.reptilia = reptilia;
    }

    public EcdiseReptilia getEcdise() {
        return ecdise;
    }

    public void setEcdise(EcdiseReptilia ecdise) {
        this.ecdise = ecdise;
    }

    public boolean isPopupNovo() {
        return popupNovo;
    }

    public void setPopupNovo(boolean popupNovo) {
        this.popupNovo = popupNovo;
    }

    public DAO<Reptilia> getDao() {
        return dao;
    }

    public void setDao(DAO<Reptilia> dao) {
        this.dao = dao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.reptilia);
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
        final EcdiseReptiliaControle other = (EcdiseReptiliaControle) obj;
        if (this.popupNovo != other.popupNovo) {
            return false;
        }
        if (!Objects.equals(this.reptilia, other.reptilia)) {
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
        return "EcdiseReptiliaControle{" + "reptilia=" + reptilia + ", ecdise=" + ecdise + ", popupNovo=" + popupNovo + ", dao=" + dao + '}';
    }
}
