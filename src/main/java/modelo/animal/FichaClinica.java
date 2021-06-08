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

@Entity
public class FichaClinica implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataProcedimento;
    
    @Column(length = 50)
    private String procedimento;
    
    @ManyToOne
    @JoinColumn(name = "animal")
    private Animal animal;
    
    public FichaClinica(){
        dataProcedimento = new Date();
        procedimento = "";
        animal = new Animal();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataProcedimento() {
        return dataProcedimento;
    }

    public void setDataProcedimento(Date dataProcedimento) {
        this.dataProcedimento = dataProcedimento;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.dataProcedimento);
        hash = 47 * hash + Objects.hashCode(this.procedimento);
        hash = 47 * hash + Objects.hashCode(this.animal);
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
        final FichaClinica other = (FichaClinica) obj;
        if (!Objects.equals(this.procedimento, other.procedimento)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataProcedimento, other.dataProcedimento)) {
            return false;
        }
        if (!Objects.equals(this.animal, other.animal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FichaClinica{" + "id=" + id + ", dataProcedimento=" + dataProcedimento + ", procedimento=" + procedimento + ", animal=" + animal + '}';
    }
    
    
}
