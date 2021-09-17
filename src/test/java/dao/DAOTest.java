package dao;

import java.util.List;
import modelo.animal.Animal;
import modelo.usuario.Administrador;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DAOTest {

    public DAOTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /*@Test
    public void testeInserirAdm() {
    Administrador adm = new Administrador();
    adm.setLogin("BIA");
    adm.setNome("Beatriz");
    adm.setSenha("123");
    adm.setCargo("Administrador");
    
    DAO <Administrador> d = new DAO(Administrador.class);
    d.inserir(adm);
    }*/
    
    
    /*@Test
    public void testeListarAdm() {
    DAO<Administrador> d = new DAO(Administrador.class);
    List<Administrador> lista = d.listarTodos();
    System.out.println("\n\n\n\n");
    for (Administrador a : lista) {
    System.out.println(a.getNome());
    }
    System.out.println("\n\n\n\n");
    }*/
    
    /*   @Test
    public void testeInserirAnimal() {
    Animal anm = new Animal();
    anm.setEspecie("Serpente");
    anm.setNomeCientifico("Cobra"):
    anm.setNomePopular("cobra");
    anm.setSexo("macho");
    anm.setLocalResgate("UENP");
    anm.setFichaClinica("Saudavel");
    anm.setAlimentacao("frutas");
    
    
    DAO <Animal> d = new DAO(Animal.class);
    d.inserir(anm);
    }*/
    
    /*   @Test
    public void testeListarAnimal() {
    DAO<Animal> d = new DAO(Animal.class);
    List<Animal> lista = d.listarTodos();
    System.out.println("\n\n\n\n");
    for (Animal a : lista) {
    System.out.println(a.getNomePopular());
    }
    System.out.println("\n\n\n\n");
    }*/

}
