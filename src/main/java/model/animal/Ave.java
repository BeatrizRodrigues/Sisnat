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
@Table(name="aves")
@DiscriminatorValue("aves")
public class Ave extends Animal implements Serializable {
    
    @OneToMany(mappedBy = "aves", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MorfometriaAves> morfometria;
    
    public Ave(){
        morfometria = new ArrayList();
    }

    public List<MorfometriaAves> getMorfometria() {
        return morfometria;
    }

    public void setMorfometria(List<MorfometriaAves> morfometria) {
        this.morfometria = morfometria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.morfometria);
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
        final Ave other = (Ave) obj;
        if (!Objects.equals(this.morfometria, other.morfometria)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ave{" + "morfometria=" + morfometria + '}';
    }   
    
}
