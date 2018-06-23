/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;
import entities.Pertenece;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author juanc
 */
@Stateless
public class PerteneceFacade extends AbstractFacade<Pertenece> {
    
    public PerteneceFacade() {
        super(Pertenece.class);
    }
    /**
     * retorna el articulo que este en la tabla de pernece
     * @param articulo
     * @return una lista con los articulos
     */
    public List<Pertenece> findByArticulo(Object articulo){
        Query q = em.createQuery("SELECT t FROM Pertenece t WHERE t.articulo = :articulo");
        q.setParameter("articulo", articulo);
        return q.getResultList();
    }
    /**
     * reteorna todos los articulos de pertenece dependiendo de la categoria
     * @param categoria
     * @return una lista con los articulos 
     */
    public List<Pertenece> findByCategoria(Object categoria){
        Query q = em.createQuery("SELECT t FROM Pertenece t WHERE t.categoria = :categoria");
        q.setParameter("categoria", categoria);
        return q.getResultList();
    }
    
}
