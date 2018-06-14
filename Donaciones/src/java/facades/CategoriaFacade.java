package facades;

import entities.Categoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> {

    public CategoriaFacade() {
        super(Categoria.class);
    }
    
    public List<Categoria> findByNombre(Object nombre){
        Query q = em.createQuery("SELECT t FROM Categoria t WHERE t.nombre = :nombre");
        q.setParameter("nombre", nombre);
        return q.getResultList();
    }
    
    public List<Categoria> findByEstado(Object estado){
        Query q = em.createQuery("SELECT t FROM Categoria t WHERE t.estado = :estado");
        q.setParameter("estado", estado);
        return q.getResultList();
    }

}
