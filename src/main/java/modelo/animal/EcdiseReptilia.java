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
public class EcdiseReptilia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataEcdise;
    
    @Column(length = 50)
    private String ecdise;
        
    @ManyToOne
    @JoinColumn(name = "reptilia")
    private Reptilia reptilia;
      
    public EcdiseReptilia(){
        dataEcdise = new Date();
        ecdise = "";
        reptilia = new Reptilia();
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

    public Reptilia getReptilia() {
        return reptilia;
    }

    public void setReptilia(Reptilia reptilia) {
        this.reptilia = reptilia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.dataEcdise);
        hash = 23 * hash + Objects.hashCode(this.ecdise);
        hash = 23 * hash + Objects.hashCode(this.reptilia);
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
        final EcdiseReptilia other = (EcdiseReptilia) obj;
        if (!Objects.equals(this.ecdise, other.ecdise)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataEcdise, other.dataEcdise)) {
            return false;
        }
        if (!Objects.equals(this.reptilia, other.reptilia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EcdiseReptilia{" + "id=" + id + ", dataEcdise=" + dataEcdise + ", ecdise=" + ecdise + ", reptilia=" + reptilia + '}';
    }
}
