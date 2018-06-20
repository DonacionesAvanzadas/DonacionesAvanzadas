/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;
import entities.ArticuloDonar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
/**
 *
 * @author usuario
 */
@Stateless
public class ArticuloDonarFacade extends AbstractFacade<ArticuloDonar>{
    
    public ArticuloDonarFacade() {
        super(ArticuloDonar.class);
    }
    
    public List<ArticuloDonar> findBySinopsis(Object Sinopsis) {
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.sinopsis = :Sinopsis");
        q.setParameter("Sinopsis", Sinopsis);
        return q.getResultList();
    }
     
    public List<ArticuloDonar> findByDescripcion(Object Descripcion) {
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.descripcion LIKE :Descripcion");
        q.setParameter("Descripcion", Descripcion);
        return q.getResultList();
    }
    
    public List<ArticuloDonar> findByImagen(Object Imagen) {
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.imagen = :Imagen");
        q.setParameter("Imagen", Imagen);
        return q.getResultList();
    }
    
    public List<ArticuloDonar> findByTema(Object Tema) {
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.tema = :Tema");
        q.setParameter("Tema", Tema);
        return q.getResultList();
    }
    
    public List<ArticuloDonar> findByUsuario(Object usuario){
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.usuario = :usuario");
        q.setParameter("usuario", usuario);
        return q.getResultList();
    }
    
    public List<ArticuloDonar> search(String tema, String descipcion){
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.tema = :Tema AND t.descripcion LIKE :Descripcion");
        q.setParameter("Tema", tema);
        q.setParameter("Descripcion", descipcion);
        return q.getResultList();
    }
    
    public List<String> getTemas(){
        Query q = em.createQuery("SELECT distinct(t.tema) FROM ArticuloDonar t");
        return q.getResultList();
    }
    
}
