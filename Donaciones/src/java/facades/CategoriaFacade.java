package facades;

import entities.Categoria;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
public class CategoriaFacade extends AbstractFacade<Categoria> {
    /**
     * constructor de la clase
     */
    public CategoriaFacade() {
        super(Categoria.class);
    }
    /**
     * Retorna todas las categorias que son iguales al campo nombre con el nombre enviado
     * @param nombre
     * @return Una lista con las categorias
     */
    public List<Categoria> findByNombre(Object nombre){
        Query q = em.createQuery("SELECT t FROM Categoria t WHERE t.nombre = :nombre");
        q.setParameter("nombre", nombre);
        return q.getResultList();
    }
    /**
     * Retorna todas las categorias que son iguales al campo estado con el estado enviado
     * @param estado
     * @return Una lista con las categorias
     */
    public List<Categoria> findByEstado(Object estado){
        Query q = em.createQuery("SELECT t FROM Categoria t WHERE t.estado = :estado");
        q.setParameter("estado", estado);
        return q.getResultList();
    }

}
