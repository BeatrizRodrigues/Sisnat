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
public class MorfometriaAmphibia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataMedicao;
    
    @Column(length = 15)
    private double peso;
    
    @Column(length = 15)
    private double crc;
    
    @Column(length = 15)
    private double cc;
    
    @Column(length = 15)
    private double don;
    
    @Column(length = 15)
    private double cf;
    
    @Column(length = 15)
    private double ct;
    
    @Column(length = 15)
    private double cta;
    
    @Column(length = 15)
    private double cp;
    
    @Column(length = 50)
    private String observacao;
    
    @ManyToOne
    @JoinColumn(name = "amphibia")
    private Amphibia amphibia;
    
    public MorfometriaAmphibia(){
        dataMedicao = new Date();
        peso = 0;
        crc = 0;
        cc = 0;
        don = 0;
        cf = 0;
        ct = 0;
        cta = 0;
        cp = 0;
        observacao = "";
        amphibia = new Amphibia();
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

    public double getCrc() {
        return crc;
    }

    public void setCrc(double crc) {
        this.crc = crc;
    }

    public double getCc() {
        return cc;
    }

    public void setCc(double cc) {
        this.cc = cc;
    }

    public double getDon() {
        return don;
    }

    public void setDon(double don) {
        this.don = don;
    }

    public double getCf() {
        return cf;
    }

    public void setCf(double cf) {
        this.cf = cf;
    }

    public double getCt() {
        return ct;
    }

    public void setCt(double ct) {
        this.ct = ct;
    }

    public double getCta() {
        return cta;
    }

    public void setCta(double cta) {
        this.cta = cta;
    }

    public double getCp() {
        return cp;
    }

    public void setCp(double cp) {
        this.cp = cp;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Amphibia getAmphibia() {
        return amphibia;
    }

    public void setAmphibia(Amphibia amphibia) {
        this.amphibia = amphibia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.dataMedicao);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.crc) ^ (Double.doubleToLongBits(this.crc) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.cc) ^ (Double.doubleToLongBits(this.cc) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.don) ^ (Double.doubleToLongBits(this.don) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.cf) ^ (Double.doubleToLongBits(this.cf) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.ct) ^ (Double.doubleToLongBits(this.ct) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.cta) ^ (Double.doubleToLongBits(this.cta) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.cp) ^ (Double.doubleToLongBits(this.cp) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.observacao);
        hash = 89 * hash + Objects.hashCode(this.amphibia);
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
        final MorfometriaAmphibia other = (MorfometriaAmphibia) obj;
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (Double.doubleToLongBits(this.crc) != Double.doubleToLongBits(other.crc)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cc) != Double.doubleToLongBits(other.cc)) {
            return false;
        }
        if (Double.doubleToLongBits(this.don) != Double.doubleToLongBits(other.don)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cf) != Double.doubleToLongBits(other.cf)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ct) != Double.doubleToLongBits(other.ct)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cta) != Double.doubleToLongBits(other.cta)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cp) != Double.doubleToLongBits(other.cp)) {
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
        if (!Objects.equals(this.amphibia, other.amphibia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MorfometriaAmphibia{" + "id=" + id + ", dataMedicao=" + dataMedicao + ", peso=" + peso + ", crc=" + crc + ", cc=" + cc + ", don=" + don + ", cf=" + cf + ", ct=" + ct + ", cta=" + cta + ", cp=" + cp + ", observacao=" + observacao + ", amphibia=" + amphibia + '}';
    }
    
    
    
}
