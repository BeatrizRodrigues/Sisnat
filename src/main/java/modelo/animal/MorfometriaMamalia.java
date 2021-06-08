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
public class MorfometriaMamalia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataMedicao;
    
    @Column(length = 15)
    private double peso;
    
    @Column(length = 15)
    private double cra;
    
    @Column(length = 15)
    private double cc;
    
    @Column(length = 15)
    private double cm;
    
    @Column(length = 15)
    private double cp;
    
    @Column(length = 15)
    private double ho;
    
    @Column(length = 50)
    private String observacao;
    
    @ManyToOne
    @JoinColumn(name = "mamalia")
    private Mammalia mamalia;
    
    public MorfometriaMamalia(){
        dataMedicao = new Date();
        peso = 0;
        cra = 0;
        cc = 0;
        cm = 0;
        cp = 0;
        ho = 0;
        observacao = "";
        mamalia = new Mammalia();
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

    public double getCra() {
        return cra;
    }

    public void setCra(double cra) {
        this.cra = cra;
    }

    public double getCc() {
        return cc;
    }

    public void setCc(double cc) {
        this.cc = cc;
    }

    public double getCm() {
        return cm;
    }

    public void setCm(double cm) {
        this.cm = cm;
    }

    public double getCp() {
        return cp;
    }

    public void setCp(double cp) {
        this.cp = cp;
    }

    public double getHo() {
        return ho;
    }

    public void setHo(double ho) {
        this.ho = ho;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Mammalia getMamalia() {
        return mamalia;
    }

    public void setMamalia(Mammalia mamalia) {
        this.mamalia = mamalia;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.dataMedicao);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.cra) ^ (Double.doubleToLongBits(this.cra) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.cc) ^ (Double.doubleToLongBits(this.cc) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.cm) ^ (Double.doubleToLongBits(this.cm) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.cp) ^ (Double.doubleToLongBits(this.cp) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.ho) ^ (Double.doubleToLongBits(this.ho) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.observacao);
        hash = 29 * hash + Objects.hashCode(this.mamalia);
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
        final MorfometriaMamalia other = (MorfometriaMamalia) obj;
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cra) != Double.doubleToLongBits(other.cra)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cc) != Double.doubleToLongBits(other.cc)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cm) != Double.doubleToLongBits(other.cm)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cp) != Double.doubleToLongBits(other.cp)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ho) != Double.doubleToLongBits(other.ho)) {
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
        if (!Objects.equals(this.mamalia, other.mamalia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MorfometriaMamalia{" + "id=" + id + ", dataMedicao=" + dataMedicao + ", peso=" + peso + ", cra=" + cra + ", cc=" + cc + ", cm=" + cm + ", cp=" + cp + ", ho=" + ho + ", observacao=" + observacao + ", mamalia=" + mamalia + '}';
    }
    
    
}
