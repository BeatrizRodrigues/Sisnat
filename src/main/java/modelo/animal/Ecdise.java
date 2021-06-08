package modelo.animal;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author beeat
 */
@Entity
public class Ecdise implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataEcdise;
    
    @Column(length = 50)
    private String ecdise;
    
    @ManyToOne
    @JoinColumn(name = "animal")
    private Animal animal;
    
    
    public Ecdise(){
        dataEcdise = new Date();
        ecdise = "";
        animal = new Animal();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataEcdise() {
        return dataEcdise;
    }

    public void setDataEcdise(Date dataEcdise) {
        this.dataEcdise = dataEcdise;
    }

    public String getEcdise() {
        return ecdise;
    }

    public void setEcdise(String ecdise) {
        this.ecdise = ecdise;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.dataEcdise);
        hash = 89 * hash + Objects.hashCode(this.ecdise);
        hash = 89 * hash + Objects.hashCode(this.animal);
        
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
        final Ecdise other = (Ecdise) obj;
        if (!Objects.equals(this.ecdise, other.ecdise)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataEcdise, other.dataEcdise)) {
            return false;
        }
        if (!Objects.equals(this.animal, other.animal)) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "Ecdise{" + "id=" + id + ", dataEcdise=" + dataEcdise + ", ecdise=" + ecdise + ", animal=" + animal + '}';
    }

    
    
}
