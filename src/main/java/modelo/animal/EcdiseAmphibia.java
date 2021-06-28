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
public class EcdiseAmphibia implements Serializable {
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
    
    public EcdiseAmphibia(){
        dataEcdise = new Date();
        ecdise = "";
        amphibia = new Amphibia();
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.dataEcdise);
        hash = 79 * hash + Objects.hashCode(this.ecdise);
        hash = 79 * hash + Objects.hashCode(this.amphibia);
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
        final EcdiseAmphibia other = (EcdiseAmphibia) obj;
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
        return true;
    }

    @Override
    public String toString() {
        return "EcdiseAmphibia{" + "id=" + id + ", dataEcdise=" + dataEcdise + ", ecdise=" + ecdise + ", amphibia=" + amphibia + '}';
    }
}
