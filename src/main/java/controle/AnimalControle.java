package controle;

import dao.DAO;
import dao.DAONome;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.animal.Amphibia;
import modelo.animal.Animal;
import modelo.animal.Arachnida;
import modelo.animal.Ave;
import modelo.animal.Mammalia;
import modelo.animal.Nome;
import modelo.animal.Reptilia;

@ViewScoped
@Named
public class AnimalControle implements Serializable {
    private Animal novoAnimal;
    private DAO<Animal> dao;
    private List<Animal> lista;
    private boolean popupNovo;
    private boolean popupAltera;
    private Nome nome; 
    private List<Nome> nomes; 
    private List<String> nomesCientificos; 
    private DAONome daoNome; 
    private boolean popupGrupo; 
    private String grupo; 
    
    
    public AnimalControle(){
        novoAnimal = new Animal();
        dao = new DAO(Animal.class);
        daoNome = new DAONome();
        lista = dao.listarTodos();
        popupNovo = false;
        popupAltera = false;
        nomes = new ArrayList(); 
        nomesCientificos = new ArrayList(); 
        popupGrupo = false;
        grupo = "";
    }
    
    public void atualizarNomes(){
        novoAnimal.setNomeCientifico(null);
        novoAnimal.setNomePopular(null);
        nomesCientificos.clear();
        nomes = daoNome.listarPorGrupo(novoAnimal.getGrupo());
        nomes.forEach(n -> {
            nomesCientificos.add(n.getNomeCientifico());
        });
        Collections.sort(nomesCientificos);
    }
    
    public void atualizarNomePopular(){
        for (Nome n : nomes){
            if (n.getNomeCientifico().equals(novoAnimal.getNomeCientifico())){
                this.novoAnimal.setNomePopular(n.getNomePopular());
                break;
            }
        }      
    }
    
    public String alimentar(Animal animal){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        ectx.getSessionMap().put("animal", animal);
        return "/animal/alimentacao";
    }
    
    public String ficha(Animal animal){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        ectx.getSessionMap().put("animal", animal);
        return "/animal/fichaClinica";
    }
    
    public String abreFicha(Animal animal){
        if (animal instanceof Reptilia){
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext ectx = context.getExternalContext();
            ectx.getSessionMap().put("animal", animal);
            System.out.println("Reptilia");
            return "reptiliaCadastrada?faces-redirect=true";
        }
        if (animal instanceof Mammalia){
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext ectx = context.getExternalContext();
            ectx.getSessionMap().put("animal", animal);
            System.out.println("Mammalia");
            return "MammaliaCadastrada?faces-redirect=true";
        }
        if (animal instanceof Ave){
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext ectx = context.getExternalContext();
            ectx.getSessionMap().put("animal", animal);
            System.out.println("Ave");
            return "AveCadastrada?faces-redirect=true";
        }
        if (animal instanceof Arachnida){
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext ectx = context.getExternalContext();
            ectx.getSessionMap().put("animal", animal);
            System.out.println("Arachnida");
            return "arachnidaCadastrada?faces-redirect=true";
        }
        if (animal instanceof Amphibia){
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext ectx = context.getExternalContext();
            ectx.getSessionMap().put("animal", animal);
            System.out.println("Amphibia");
            return "amphibiaCadastrada?faces-redirect=true";
        }   
    
        return null;
    }
    
    public void abrePopupGrupo(){
        this.popupGrupo = true;
    }
    
     public void fechaPopupGrupo(){
        this.popupGrupo = false;
    }
     
    public void abrePopupNovo() {
        novoAnimal = new Animal();
        this.popupNovo = true;
    }

    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
    public void abrePopupAltera(){        
        this.popupAltera = true;
    }
    
    public void fecharPopupAltera(){
        this.popupAltera = false;
    }
    
    public void alterar(){
        abrePopupAltera();
    }
    
    
    public String preparaNovoAnimal(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        ectx.getSessionMap().put("grupo", grupo); 
        return "novoAnimal?faces-redirect=true";
    }
    
    public void alterarAnimal() {
        dao.alterar(novoAnimal);
        lista = dao.listarTodos(); // atualiza a lista
        novoAnimal = new Animal(); 
        fecharPopupAltera();
    }
    
    public void excluir(Animal animal){
        dao.excluir(animal.getId());
        lista.remove(animal);
    }

    public Animal getNovoAnimal() {
        return novoAnimal;
    }

    public void setNovoAnimal(Animal animal) {
        this.novoAnimal = animal;
    }

        
    public Nome getNome() {
        return nome;
    }

    public void setNome(Nome nome) {
        this.nome = nome;
    }

    public List<String> getNomesCientificos() {
        return nomesCientificos;
    }

    public void setNomesCientificos(List<String> nomesCientificos) {
        this.nomesCientificos = nomesCientificos;
    }
    
    

    public List<Animal> getLista() {
        return lista;
    }

    public void setLista(List<Animal> lista) {
        this.lista = lista;
    }

    public boolean isPopupNovo() {
        return popupNovo;
    }

    public void setPopupNovo(boolean popupNovo) {
        this.popupNovo = popupNovo;
    }

    public boolean isPopupAltera() {
        return popupAltera;
    }

    public void setPopupAltera(boolean popupAltera) {
        this.popupAltera = popupAltera;
    }

    public boolean isPopupGrupo() {
        return popupGrupo;
    }

    public void setPopupGrupo(boolean popupGrupo) {
        this.popupGrupo = popupGrupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    
    

}
