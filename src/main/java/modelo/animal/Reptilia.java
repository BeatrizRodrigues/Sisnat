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
@Table(name="reptilia")
@DiscriminatorValue("reptilia")
public class Reptilia extends Animal implements Serializable {
       
    @OneToMany(mappedBy = "reptilia", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MorfometriaReptilia> morfometrias;
    
    @OneToMany(mappedBy = "reptilia", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EcdiseReptilia> ecdises;
    
    public Reptilia(){
        morfometrias = new ArrayList();
        ecdises = new ArrayList();
    }

    public List<MorfometriaReptilia> getMorfometrias() {
        return morfometrias;
    }

    public void setMorfometrias(List<MorfometriaReptilia> morfometria) {
        this.morfometrias = morfometria;
    }

    public List<EcdiseReptilia> getEcdises() {
        return ecdises;
    }

    public void setEcdises(List<EcdiseReptilia> ecdises) {
        this.ecdises = ecdises;
    }  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.morfometrias);
        hash = 89 * hash + Objects.hashCode(this.ecdises);
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
        final Reptilia other = (Reptilia) obj;
        if (!Objects.equals(this.morfometrias, other.morfometrias)) {
            return false;
        }
        if (!Objects.equals(this.ecdises, other.ecdises)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reptilia{" + "morfometrias=" + morfometrias + ", ecdises=" + ecdises + '}';
    }
    
    

    
    
    
}
