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
import modelo.animal.Amphibia;
import modelo.animal.Animal;
import modelo.animal.Arachnida;
import modelo.animal.Ave;
import modelo.animal.Mammalia;
import modelo.animal.Nome;
import modelo.animal.Reptilia;

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
        if(grupo.equals("Ave")){
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
        if(grupo.equals("Ave")){
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
    
    
    
}
