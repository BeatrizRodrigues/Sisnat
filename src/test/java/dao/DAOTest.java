
package dao;

import java.util.List;
import modelo.usuario.Administrador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author beeat
 */
public class DAOTest {
    
    public DAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        
    }

  /*@Test
    public void testeInserirAdm() {
        Administrador adm = new Administrador();
        adm.setLogin("Amora");
        adm.setNome("Izabelle");
        adm.setSenha("123456");
        adm.setCargo("Estagiario");
        
        DAO <Administrador> d = new DAO(Administrador.class);
        d.inserir(adm);
    }*/
    
    @Test
    public void testeListarAdm(){
        DAO <Administrador> d = new DAO(Administrador.class);
        List<Administrador> lista = d.listarTodos();
        for(Administrador a: lista){
            System.out.println(a.getNome());
        }
    }
    
    
    
}
