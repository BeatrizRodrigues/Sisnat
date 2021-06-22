package modelo.animal;

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
@Table(name="arachnida")
@DiscriminatorValue("arachnida")
public class Arachnida extends Animal implements Serializable {
        
    @OneToMany(mappedBy = "arachnida", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MorfometriaArachnida> morfometria;
    
    @OneToMany(mappedBy = "arachnida", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ecdise> ecdises;
    
    public Arachnida(){
        morfometria = new ArrayList();
        ecdises = new ArrayList();
    }

    public List<MorfometriaArachnida> getMorfometria() {
        return morfometria;
    }

    public void setMorfometria(List<MorfometriaArachnida> morfometria) {
        this.morfometria = morfometria;
    }

    public List<Ecdise> getEcdises() {
        return ecdises;
    }

    public void setEcdises(List<Ecdise> ecdises) {
        this.ecdises = ecdises;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.morfometria);
        hash = 79 * hash + Objects.hashCode(this.ecdises);
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
        final Arachnida other = (Arachnida) obj;
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
        return "Arachnida{" + "morfometria=" + morfometria + ", ecdises=" + ecdises + '}';
    }

    
}
