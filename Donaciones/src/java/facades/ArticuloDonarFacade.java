/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;
import entities.ArticuloDonar;
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
    /**
     * Retorna todos los articulos de donacion que son iguales al campo sinopsis con la sinopsis enviada
     * @param Sinopsis
     * @return Una lista de articuloDonar
     */
    public List<ArticuloDonar> findBySinopsis(Object Sinopsis) {
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.sinopsis = :Sinopsis");
        q.setParameter("Sinopsis", Sinopsis);
        return q.getResultList();
    }
     /**
      * Retorna todos los articulos de donacion que son iguales al campo descripcion con la descripcion enviada
      * @param Descripcion
      * @return Una lista de articulosDonar 
      */
    public List<ArticuloDonar> findByDescripcion(Object Descripcion) {
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.descripcion = :Descripcion");
        q.setParameter("Descripcion", Descripcion);
        return q.getResultList();
    }
    /**
     * Retorna todos los articulos de donacion que son iguales al campo imagen con la imagen enviada
     * @param Imagen
     * @return Una lista de articulosDonar 
     */
    public List<ArticuloDonar> findByImagen(Object Imagen) {
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.imagen = :Imagen");
        q.setParameter("Imagen", Imagen);
        return q.getResultList();
    }
    /**
     * Retorna todos los articulos de donacion que son iguales al campo tema con el tema enviado
     * @param Tema
     * @return Una lista de articulosDonar 
     */
    public List<ArticuloDonar> findByTema(Object Tema) {
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.tema = :Tema");
        q.setParameter("Tema", Tema);
        return q.getResultList();
    }
    /**
     * Retorna todos los articulos de donacion que son iguales al campo usuario con el usuario enviado
     * @param usuario
     * @return Una lista de articulosDonar 
     */
    public List<ArticuloDonar> findByUsuario(Object usuario){
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.usuario = :usuario");
        q.setParameter("usuario", usuario);
        return q.getResultList();
    }
    
}
