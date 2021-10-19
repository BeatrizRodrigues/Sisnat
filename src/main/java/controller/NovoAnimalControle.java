package controller;

import dao.DAO;
import dao.DAONome;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import model.animal.Amphibia;
import model.animal.Animal;
import model.animal.Arachnida;
import model.animal.Ave;
import model.animal.Mammalia;
import model.animal.Nome;
import model.animal.Reptilia;

/**
 *
 * @author User
 */
@ViewScoped
@Named
public class NovoAnimalControle implements Serializable {
    private String grupo;
    private DAO dao; 
    private Animal novoAnimal; 
    private DAONome daoNome;
    private List<Nome> nomes; 
    private List<String> nomesCientificos; 
    private Boolean habilitaDoador;
    private Boolean habilitaMotivo;
    
    
    @PostConstruct
    public void inicializar(){
        nomesCientificos = new ArrayList(); 
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        grupo = (String) ectx.getSessionMap().get("grupo");
        habilitaDoador = false;
        
        if(grupo.equals("Reptilia")){
            novoAnimal = new Reptilia(); 
            dao = new DAO(Reptilia.class);
        }
        if(grupo.equals("Aves")){
           novoAnimal = new Ave();
           dao = new DAO(Ave.class);
        }
        if(grupo.equals("Amphibia")){
            novoAnimal = new Amphibia();
            dao = new DAO(Amphibia.class);
        }
        if(grupo.equals("Mammalia")){
            novoAnimal = new Mammalia();
            dao = new DAO(Mammalia.class);
        }
        if(grupo.equals("Arachnida")){
            novoAnimal = new Arachnida();
            dao = new DAO(Arachnida.class);
        }
        
        daoNome = new DAONome(); 
        nomes = daoNome.listarPorGrupo(grupo); 
        nomes.forEach(n -> {
            nomesCientificos.add(n.getNomeCientifico());
        });
        Collections.sort(nomesCientificos);
    }
    
    public void habilitarDoador(){
        if(novoAnimal.getProcedencia().equals("Entrega voluntária")){
            habilitaDoador = true;
        }else{
            habilitaDoador = false;
        }
    }
    
    public void habilitarMotivo(){
        if(novoAnimal.getMotivo().equals("Animal encaminhado para o IPEVS através do IBAMA") || 
                novoAnimal.getMotivo().equals("Animal encaminhado para o IPEVS através do IAT") || 
                novoAnimal.getMotivo().equals("Animal encaminhado para o IPEVS através da Polí­cia Ambiental")){
            habilitaMotivo = true;
        }else{
            habilitaMotivo = false;
        }
    }
    
    public void atualizarNomePopular(){
        for (Nome n : nomes){
            if (n.getNomeCientifico().equals(novoAnimal.getNomeCientifico())){
                this.novoAnimal.setNomePopular(n.getNomePopular());
                break;
            }
        }      
    }
    
    public String inserir(){        
        if(grupo.equals("Reptilia")){
            Reptilia r = (Reptilia)novoAnimal;
            DAO<Reptilia> aux = new DAO(Reptilia.class);
            aux.inserir(r);
        }
        if(grupo.equals("Mammalia")){
            Mammalia m = (Mammalia)novoAnimal;
            DAO<Mammalia> aux = new DAO(Mammalia.class);
            aux.inserir(m);
        }
        if(grupo.equals("Amphibia")){
            Amphibia am = (Amphibia)novoAnimal;
            DAO<Amphibia> aux = new DAO(Amphibia.class);
            aux.inserir(am);
        }
        if(grupo.equals("Aves")){
            Ave ave = (Ave)novoAnimal;
            DAO<Ave> aux = new DAO(Ave.class);
            aux.inserir(ave);
        }
        if(grupo.equals("Arachnida")){
            Arachnida ar = (Arachnida)novoAnimal;
            DAO<Arachnida> aux = new DAO(Arachnida.class);
            aux.inserir(ar);
        }
        
        return "animal?faces-redirect=true";
    }

    public Boolean getHabilitaDoador() {
        return habilitaDoador;
    }

    public void setHabilitaDoador(Boolean habilitaDoador) {
        this.habilitaDoador = habilitaDoador;
    }   
    
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Animal getNovoAnimal() {
        return novoAnimal;
    }

    public void setNovoAnimal(Animal novoAnimal) {
        this.novoAnimal = novoAnimal;
    }

    public List<Nome> getNomes() {
        return nomes;
    }

    public void setNomes(List<Nome> nomes) {
        this.nomes = nomes;
    }

    public List<String> getNomesCientificos() {
        return nomesCientificos;
    }

    public void setNomesCientificos(List<String> nomesCientificos) {
        this.nomesCientificos = nomesCientificos;
    }

    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    public DAONome getDaoNome() {
        return daoNome;
    }

    public void setDaoNome(DAONome daoNome) {
        this.daoNome = daoNome;
    }

    public Boolean getHabilitaMotivo() {
        return habilitaMotivo;
    }

    public void setHabilitaMotivo(Boolean habilitaMotivo) {
        this.habilitaMotivo = habilitaMotivo;
    }
        
}
