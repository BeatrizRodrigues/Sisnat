package model.animal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author beeat
 */
@Entity
@Table(name="amphibia")
@DiscriminatorValue("amphibia")
public class Amphibia extends Animal implements Serializable {
        
    @OneToMany(mappedBy = "amphibia", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MorfometriaAmphibia> morfometria;
    
    @OneToMany(mappedBy = "amphibia", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EcdiseAmphibia> ecdises;
    
    public Amphibia(){
        morfometria = new ArrayList();
        ecdises = new ArrayList();
    }

    public List<MorfometriaAmphibia> getMorfometria() {
        return morfometria;
    }

    public void setMorfometria(List<MorfometriaAmphibia> morfometria) {
        this.morfometria = morfometria;
    }

    public List<EcdiseAmphibia> getEcdises() {
        return ecdises;
    }

    public void setEcdises(List<EcdiseAmphibia> ecdises) {
        this.ecdises = ecdises;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.morfometria);
        hash = 83 * hash + Objects.hashCode(this.ecdises);
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
        final Amphibia other = (Amphibia) obj;
        if (!Objects.equals(this.morfometria, other.morfometria)) {
            return false;
        }
        if (!Objects.equals(this.ecdises, other.ecdises)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Amphibia{" + "morfometria=" + morfometria + ", ecdises=" + ecdises + '}';
    }
}
