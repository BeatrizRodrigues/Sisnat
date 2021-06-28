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
public class EcdiseArachnida implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataEcdise;
    
    @Column(length = 50)
    private String ecdise;
    
    @ManyToOne
    @JoinColumn(name = "arachnida")
    private Arachnida arachnida;
    
    public EcdiseArachnida(){
        dataEcdise = new Date();
        ecdise = "";
        arachnida = new Arachnida();
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

    public Arachnida getArachnida() {
        return arachnida;
    }

    public void setArachnida(Arachnida arachnida) {
        this.arachnida = arachnida;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.dataEcdise);
        hash = 71 * hash + Objects.hashCode(this.ecdise);
        hash = 71 * hash + Objects.hashCode(this.arachnida);
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
        final EcdiseArachnida other = (EcdiseArachnida) obj;
        if (!Objects.equals(this.ecdise, other.ecdise)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataEcdise, other.dataEcdise)) {
            return false;
        }
        if (!Objects.equals(this.arachnida, other.arachnida)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EcdiseArachnida{" + "id=" + id + ", dataEcdise=" + dataEcdise + ", ecdise=" + ecdise + ", arachnida=" + arachnida + '}';
    }
    
}
