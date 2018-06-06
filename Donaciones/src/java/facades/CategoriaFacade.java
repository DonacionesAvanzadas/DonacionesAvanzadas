package facades;

import entities.Categoria;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
public class CategoriaFacade extends AbstractFacade<Categoria> {

    public CategoriaFacade() {
        super(Categoria.class);
    }
    
    public List<Categoria> findByEstado(Object estado){
        Query q = em.createQuery("SELECT t FROM Categoria t WHERE t.estado = :estado");
        q.setParameter("estado", estado);
        return q.getResultList();
    }

}
