/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;
import entities.ArticuloDonar;
import entities.Categoria;
import java.util.List;
import javax.persistence.Query;
/**
 *
 * @author usuario
 */
public class ArticuloDonarFacade extends AbstractFacade<ArticuloDonar>{
    
    public ArticuloDonarFacade() {
        super(ArticuloDonar.class);
    }
  
     
      public List<ArticuloDonar> findBySinopsis(Object Sinopsis){
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.Sinopsis = :Sinopsis");
        q.setParameter("Sinpsis", Sinopsis);
        return q.getResultList();
    }
      
      
       public List<ArticuloDonar> findByDescripcion(Object Descripcion){
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.Descripcion = :Descripcion");
        q.setParameter("Descripcion", Descripcion);
        return q.getResultList();
    }
       
        public List<ArticuloDonar> findByImagen(Object Imagen){
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.Imagen = :Imagen");
        q.setParameter("Imagen", Imagen);
        return q.getResultList();
    }
        
         public List<ArticuloDonar> findByTema(Object Tema){
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.Tema = :Tema");
        q.setParameter("Tema", Tema);
        return q.getResultList();
    }
}
