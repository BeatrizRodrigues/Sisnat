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
@Table(name="amphibia")
@DiscriminatorValue("amphibia")
public class Amphibia extends Animal implements Serializable {
        
    @OneToMany(mappedBy = "amphibia", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MorfometriaAmphibia> morfometria;
    
    public Amphibia(){
        morfometria = new ArrayList();
    }

    public List<MorfometriaAmphibia> getMorfometria() {
        return morfometria;
    }

    public void setMorfometria(List<MorfometriaAmphibia> morfometria) {
        this.morfometria = morfometria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.morfometria);
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
        return true;
    }

    

    @Override
    public String toString() {
        return "Amphibia{" + ", morfometria=" + morfometria + '}';
    }
    
    
            
}
