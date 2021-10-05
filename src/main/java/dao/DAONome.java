package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.animal.Nome;
import util.JpaUtil;

public class DAONome implements Serializable {

    /**
     * Busca todos animais de um grupo. 
     * @param grupo
     * @return 
     */
    public List<Nome> listarPorGrupo(String grupo) {
        EntityManager manager = JpaUtil.getEntityManager();
        TypedQuery<Nome> query = manager.createNamedQuery("Nome.findByGrupo", Nome.class);
        query.setParameter("grupo", grupo);
        List<Nome> lista = query.getResultList();
        return lista;
    }
    
    /**
     * Retorna o objeto com o nome cientÃ­fico passado. 
     * @param nomeCientifico
     * @return 
     */
    public Nome buscarPorNomeCientifico(String nomeCientifico){
        EntityManager manager = JpaUtil.getEntityManager();
        TypedQuery<Nome> query = manager.createNamedQuery("Nome.findByNomeCientifico", Nome.class);
        query.setParameter("nomeCientifico", nomeCientifico);
        try {
            if (query.getSingleResult() != null) {
                return query.getSingleResult();
            } else {
                return null;
            }
        } catch (NoResultException e) {
            return null;
        }
    }
    

}
