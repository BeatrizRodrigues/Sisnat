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
    @JoinColumn(name = "amphibia")
    private Amphibia amphibia;
    
    @ManyToOne
    @JoinColumn(name = "reptilia")
    private Reptilia reptilia;
    
    @ManyToOne
    @JoinColumn(name = "arachnida")
    private Arachnida arachnida;
    
    
    public Ecdise(){
        dataEcdise = new Date();
        ecdise = "";
        amphibia = new Amphibia();
        arachnida = new Arachnida();
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

    public Amphibia getAmphibia() {
        return amphibia;
    }

    public void setAmphibia(Amphibia amphibia) {
        this.amphibia = amphibia;
    }

    public Reptilia getReptilia() {
        return reptilia;
    }

    public void setReptilia(Reptilia reptilia) {
        this.reptilia = reptilia;
    }

    public Arachnida getArachnida() {
        return arachnida;
    }

    public void setArachnida(Arachnida arachnida) {
        this.arachnida = arachnida;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.dataEcdise);
        hash = 97 * hash + Objects.hashCode(this.ecdise);
        hash = 97 * hash + Objects.hashCode(this.amphibia);
        hash = 97 * hash + Objects.hashCode(this.reptilia);
        hash = 97 * hash + Objects.hashCode(this.arachnida);
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
        if (!Objects.equals(this.amphibia, other.amphibia)) {
            return false;
        }
        if (!Objects.equals(this.reptilia, other.reptilia)) {
            return false;
        }
        if (!Objects.equals(this.arachnida, other.arachnida)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ecdise{" + "id=" + id + ", dataEcdise=" + dataEcdise + ", ecdise=" + ecdise + ", amphibia=" + amphibia + ", reptilia=" + reptilia + ", arachnida=" + arachnida + '}';
    } 
    
}
