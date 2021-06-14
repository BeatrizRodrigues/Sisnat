package modelo.animal;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author beeat
 */
@Entity
@Table(name = "nome")
@NamedQueries({
    @NamedQuery(name = "Nome.findAll", query = "SELECT n FROM Nome n ORDER BY n.grupo"),
    @NamedQuery(name = "Nome.findById", query = "SELECT n FROM Nome n WHERE n.id = :id"),
    @NamedQuery(name = "Nome.findByGrupo", query = "SELECT n FROM Nome n WHERE n.grupo = :grupo"),
    @NamedQuery(name = "Nome.findByNomeCientifico", query = "SELECT n FROM Nome n WHERE n.nomeCientifico = :nomeCientifico"),
})
public class Nome implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length=50)
    private String grupo;
    @Column(length=70)
    private String nomeCientifico;
    @Column(length=50)
    private String nomePopular;
    
    public Nome(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getNomePopular() {
        return nomePopular;
    }

    public void setNomePopular(String nomePopular) {
        this.nomePopular = nomePopular;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.grupo);
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
        final Nome other = (Nome) obj;
        if (!Objects.equals(this.grupo, other.grupo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nome{" + "id=" + id + ", grupo=" + grupo + ", nomeCientifico=" + nomeCientifico + ", nomePopular=" + nomePopular + '}';
    }
    
}

