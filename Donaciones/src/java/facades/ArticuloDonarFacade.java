/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;
import entities.ArticuloDonar;
import entities.Categoria;
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
    /**
     * retorna una lista de articulos que pertenescan a cierta categoria
     * @param cat la id de la categoria
     * @return una lista con los productos
     */
        public List<ArticuloDonar> getByCategoria(Categoria cat){
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t, Pertenece p WHERE p.articulo = t AND p.categoria.id = :id");
        q.setParameter("id", cat.getId());
        return q.getResultList();
    }
    /**
     * busca los articulos dependiendo de su descripcion 
     * @param tema el tema que tiene el articulo
     * @param descipcion la busquda para el articulo
     * @return retorna un lista de los articulos que coinciden
     */
    public List<ArticuloDonar> search(String tema, String descipcion){
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.tema = :Tema AND t.descripcion LIKE :Descripcion");
        q.setParameter("Tema", tema);
        q.setParameter("Descripcion", descipcion);
        return q.getResultList();
    }
    /**
     * muestra una lista de articulos con los temas
     * @return lista de articulos 
     */
    public List<String> getTemas(){
        Query q = em.createQuery("SELECT distinct(t.tema) FROM ArticuloDonar t");
        return q.getResultList();
    }
    
}
