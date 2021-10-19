
package model.animal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="animal")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo", discriminatorType=DiscriminatorType.STRING,length=20)
@DiscriminatorValue("animal")
public class Animal implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
        
    @Column(length = 30)
    private String grupo;
    
    @Column(length = 30)
    private String nomeCientifico;
    
    @Column(length = 30)
    private String nomePopular;
    
    @Column(length = 10)
    private String sexo;
     
    @Column(length = 10)
    private String faixaEtaria;
    
    @Column(length = 20)
    private String condicaoFisica;  
    
    @Column(length = 50)
    private String procedencia;
    
    @Column(length = 50)
    private String motivo;
    
    @Column(length = 50)
    private String BO;
   
    @Column(length = 30)
    private String municipioDeOrigem;
    
    @Column(length = 50)
    private String endereco;
    
    @Column(length = 30)
    private String coordenadas;
    
    @Column(length = 50)
    private String nomeDoador;
    
    @Column(length = 30)
    private Integer telefone;
    
    @Column(length = 30)
    private String areaDoResgate;
        
    @Column(name = "data_entrada")
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    @Column(length = 100)
    private String observacao;
    
    @Column
    private boolean soltura;
    
    @OneToMany(mappedBy = "animal", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alimentacao> alimentacoes;
    
    @OneToMany(mappedBy = "animal", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FichaClinica> fichas;    
    
    @OneToMany(mappedBy = "animal", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Observacao> observacoes;
    
   
    public Animal(){
        id = 0;
        grupo = "";
        nomeCientifico = "";
        nomePopular = "";
        sexo = "";
        faixaEtaria = "";
        condicaoFisica = "";
        procedencia = "";
        motivo = "";
        BO = "";
        municipioDeOrigem = "";
        endereco = "";
        coordenadas = "";
        nomeDoador = "";
        telefone = 0;
        areaDoResgate = "";
        dataEntrada = new Date();
        dataNascimento = new Date();
        observacao = "";
        fichas = new ArrayList();
        alimentacoes = new ArrayList();
        observacoes = new ArrayList();
        soltura = false;
    }
    
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getCondicaoFisica() {
        return condicaoFisica;
    }

    public void setCondicaoFisica(String condicaoFisica) {
        this.condicaoFisica = condicaoFisica;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getBO() {
        return BO;
    }

    public void setBO(String BO) {
        this.BO = BO;
    }

    public String getMunicipioDeOrigem() {
        return municipioDeOrigem;
    }

    public void setMunicipioDeOrigem(String municipioDeOrigem) {
        this.municipioDeOrigem = municipioDeOrigem;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getNomeDoador() {
        return nomeDoador;
    }

    public void setNomeDoador(String nomeDoador) {
        this.nomeDoador = nomeDoador;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getAreaDoResgate() {
        return areaDoResgate;
    }

    public void setAreaDoResgate(String areaDoResgate) {
        this.areaDoResgate = areaDoResgate;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean isSoltura() {
        return soltura;
    }

    public void setSoltura(boolean soltura) {
        this.soltura = soltura;
    }

    public List<Alimentacao> getAlimentacoes() {
        return alimentacoes;
    }

    public void setAlimentacoes(List<Alimentacao> alimentacoes) {
        this.alimentacoes = alimentacoes;
    }

    public List<FichaClinica> getFichas() {
        return fichas;
    }

    public void setFichas(List<FichaClinica> fichas) {
        this.fichas = fichas;
    }

    public List<Observacao> getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(List<Observacao> observacoes) {
        this.observacoes = observacoes;
    }

    /*public List<Ecdise> getEcdise() {
        return ecdise;
    }

    public void setEcdise(List<Ecdise> ecdise) {
        this.ecdise = ecdise;
    }*/
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.grupo);
        hash = 59 * hash + Objects.hashCode(this.nomeCientifico);
        hash = 59 * hash + Objects.hashCode(this.nomePopular);
        hash = 59 * hash + Objects.hashCode(this.sexo);
        hash = 59 * hash + Objects.hashCode(this.faixaEtaria);
        hash = 59 * hash + Objects.hashCode(this.condicaoFisica);
        hash = 59 * hash + Objects.hashCode(this.procedencia);
        hash = 59 * hash + Objects.hashCode(this.motivo);
        hash = 59 * hash + Objects.hashCode(this.BO);
        hash = 59 * hash + Objects.hashCode(this.municipioDeOrigem);
        hash = 59 * hash + Objects.hashCode(this.endereco);
        hash = 59 * hash + Objects.hashCode(this.coordenadas);
        hash = 59 * hash + Objects.hashCode(this.nomeDoador);
        hash = 59 * hash + Objects.hashCode(this.telefone);
        hash = 59 * hash + Objects.hashCode(this.areaDoResgate);
        hash = 59 * hash + Objects.hashCode(this.dataEntrada);
        hash = 59 * hash + Objects.hashCode(this.dataNascimento);
        hash = 59 * hash + Objects.hashCode(this.observacao);
        hash = 59 * hash + (this.soltura ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.alimentacoes);
        hash = 59 * hash + Objects.hashCode(this.fichas);
        hash = 59 * hash + Objects.hashCode(this.observacoes);
        //hash = 59 * hash + Objects.hashCode(this.ecdise);
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
        final Animal other = (Animal) obj;
        if (this.soltura != other.soltura) {
            return false;
        }
        if (!Objects.equals(this.grupo, other.grupo)) {
            return false;
        }
        if (!Objects.equals(this.nomeCientifico, other.nomeCientifico)) {
            return false;
        }
        if (!Objects.equals(this.nomePopular, other.nomePopular)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.faixaEtaria, other.faixaEtaria)) {
            return false;
        }
        if (!Objects.equals(this.condicaoFisica, other.condicaoFisica)) {
            return false;
        }
        if (!Objects.equals(this.procedencia, other.procedencia)) {
            return false;
        }
        if (!Objects.equals(this.motivo, other.motivo)) {
            return false;
        }
        if (!Objects.equals(this.BO, other.BO)) {
            return false;
        }
        if (!Objects.equals(this.municipioDeOrigem, other.municipioDeOrigem)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.coordenadas, other.coordenadas)) {
            return false;
        }
        if (!Objects.equals(this.nomeDoador, other.nomeDoador)) {
            return false;
        }
        if (!Objects.equals(this.areaDoResgate, other.areaDoResgate)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.dataEntrada, other.dataEntrada)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.alimentacoes, other.alimentacoes)) {
            return false;
        }
        if (!Objects.equals(this.fichas, other.fichas)) {
            return false;
        }
        if (!Objects.equals(this.observacoes, other.observacoes)) {
            return false;
        }
        /*if (!Objects.equals(this.ecdise, other.ecdise)) {
            return false;
        }*/
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", grupo=" + grupo + ", nomeCientifico=" + nomeCientifico + ", nomePopular=" + nomePopular + ", sexo=" + sexo + ", faixaEtaria=" + faixaEtaria + ", condicaoFisica=" + condicaoFisica + ", procedencia=" + procedencia + ", motivo=" + motivo + ", BO=" + BO + ", municipioDeOrigem=" + municipioDeOrigem + ", endereco=" + endereco + ", coordenadas=" + coordenadas + ", nomeDoador=" + nomeDoador + ", telefone=" + telefone + ", areaDoResgate=" + areaDoResgate + ", dataEntrada=" + dataEntrada + ", dataNascimento=" + dataNascimento + ", observacao=" + observacao + ", soltura=" + soltura + ", alimentacoes=" + alimentacoes + ", fichas=" + fichas + ", observacoes=" + observacoes + '}';
    }

    

    

}
