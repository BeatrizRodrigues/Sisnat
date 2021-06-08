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
public class MorfometriaArachnida implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataMedicao;
    
    @Column(length = 15)
    private double peso;
    
    @Column(length = 15)
    private double cc;
    
    @Column(length = 15)
    private double cp;
    
    @Column(length = 15)
    private double cpp;
    
    @Column(length = 50)
    private String observacao;
    
    @ManyToOne
    @JoinColumn(name = "arachnida")
    private Arachnida arachnida;
    
    public MorfometriaArachnida(){
        dataMedicao = new Date();
        peso = 0;
        cc = 0;
        cp = 0;
        cpp = 0;
        observacao = "";
        arachnida = new Arachnida();
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

    public double getCc() {
        return cc;
    }

    public void setCc(double cc) {
        this.cc = cc;
    }

    public double getCp() {
        return cp;
    }

    public void setCp(double cp) {
        this.cp = cp;
    }

    public double getCpp() {
        return cpp;
    }

    public void setCpp(double cpp) {
        this.cpp = cpp;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.dataMedicao);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.cc) ^ (Double.doubleToLongBits(this.cc) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.cp) ^ (Double.doubleToLongBits(this.cp) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.cpp) ^ (Double.doubleToLongBits(this.cpp) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.observacao);
        hash = 29 * hash + Objects.hashCode(this.arachnida);
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
        final MorfometriaArachnida other = (MorfometriaArachnida) obj;
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cc) != Double.doubleToLongBits(other.cc)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cp) != Double.doubleToLongBits(other.cp)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cpp) != Double.doubleToLongBits(other.cpp)) {
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
        if (!Objects.equals(this.arachnida, other.arachnida)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MorfometriaArachnida{" + "id=" + id + ", dataMedicao=" + dataMedicao + ", peso=" + peso + ", cc=" + cc + ", cp=" + cp + ", cpp=" + cpp + ", observacao=" + observacao + ", arachnida=" + arachnida + '}';
    }
    
    
    
}
