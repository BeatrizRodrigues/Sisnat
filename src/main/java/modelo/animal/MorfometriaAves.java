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
public class MorfometriaAves implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataMedicao;
    
    @Column(length = 15)
    private double peso;
    
    @Column(length = 15)
    private double cb;
    
    @Column(length = 15)
    private double h;
    
    @Column(length = 15)
    private double cc;
    
    @Column(length = 15)
    private double ca;
    
    @Column(length = 15)
    private double ct;
    
    @Column(length = 50)
    private String observacao;
    
    @ManyToOne
    @JoinColumn(name = "aves")
    private Ave aves;
    
    public MorfometriaAves(){
        dataMedicao = new Date();
        peso = 0;
        cb = 0;
        h = 0;
        cc = 0;
        ca = 0;
        ct = 0;
        observacao = "";
        aves = new Ave();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataMedicao() {
        return dataMedicao;
    }

    public void setDataMedicao(Date dataMedicao) {
        this.dataMedicao = dataMedicao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getCb() {
        return cb;
    }

    public void setCb(double cb) {
        this.cb = cb;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getCc() {
        return cc;
    }

    public void setCc(double cc) {
        this.cc = cc;
    }

    public double getCa() {
        return ca;
    }

    public void setCa(double ca) {
        this.ca = ca;
    }

    public double getCt() {
        return ct;
    }

    public void setCt(double ct) {
        this.ct = ct;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Ave getAves() {
        return aves;
    }

    public void setAves(Ave aves) {
        this.aves = aves;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.dataMedicao);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.cb) ^ (Double.doubleToLongBits(this.cb) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.h) ^ (Double.doubleToLongBits(this.h) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.cc) ^ (Double.doubleToLongBits(this.cc) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.ca) ^ (Double.doubleToLongBits(this.ca) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.ct) ^ (Double.doubleToLongBits(this.ct) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.observacao);
        hash = 79 * hash + Objects.hashCode(this.aves);
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
        final MorfometriaAves other = (MorfometriaAves) obj;
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cb) != Double.doubleToLongBits(other.cb)) {
            return false;
        }
        if (Double.doubleToLongBits(this.h) != Double.doubleToLongBits(other.h)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cc) != Double.doubleToLongBits(other.cc)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ca) != Double.doubleToLongBits(other.ca)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ct) != Double.doubleToLongBits(other.ct)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataMedicao, other.dataMedicao)) {
            return false;
        }
        if (!Objects.equals(this.aves, other.aves)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MorfometriaAves{" + "id=" + id + ", dataMedicao=" + dataMedicao + ", peso=" + peso + ", cb=" + cb + ", h=" + h + ", cc=" + cc + ", ca=" + ca + ", ct=" + ct + ", observacao=" + observacao + ", aves=" + aves + '}';
    }
    
    
}
