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
    
    /**
     * Constructor 
     */
    public ArticuloDonarFacade() {
        super(ArticuloDonar.class);
    }
    
    /**
     * selecciona un articulo a donar segun la id 
     * @param id valor del id que se va a seleccionar 
     * @return valor de la consulta 
     */
    public ArticuloDonar find(int id){
       Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.id = :id");
       q.setParameter("id", id);
       return (ArticuloDonar)q.getSingleResult();
    }
    /**
     * consulta que se realiza para uscar por sinopsis 
     * @param Sinopsis nombre de la sinopss 
     * @return 
     */
    
    public List<ArticuloDonar> findBySinopsis(Object Sinopsis) {
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.sinopsis = :Sinopsis");
        q.setParameter("Sinopsis", Sinopsis);
        return q.getResultList();
    }
     
    /**
     * Consulta que se usa para buscar por descripcion
     * @param Descripcion 
     * @return 
     */
    public List<ArticuloDonar> findByDescripcion(Object Descripcion) {
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.descripcion LIKE :Descripcion");
        q.setParameter("Descripcion", Descripcion);
        return q.getResultList();
    }
    
    /**
     * Consulta para buscar por imagen
     * @param Imagen
     * @return 
     */
    public List<ArticuloDonar> findByImagen(Object Imagen) {
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.imagen = :Imagen");
        q.setParameter("Imagen", Imagen);
        return q.getResultList();
    }
    
    /**
     * Consulta para buscar por tema 
     * @param Tema
     * @return 
     */
    public List<ArticuloDonar> findByTema(Object Tema) {
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.tema = :Tema");
        q.setParameter("Tema", Tema);
        return q.getResultList();
    }
    
    /**
     * Consulta para buscar por usuario
     * @param usuario
     * @return 
     */
    public List<ArticuloDonar> findByUsuario(Object usuario){
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.usuario = :usuario");
        q.setParameter("usuario", usuario);
        return q.getResultList();
    }
    
    /**
     * Consulta para buscar por categoria
     * @param cat
     * @return 
     */
        public List<ArticuloDonar> getByCategoria(Categoria cat){
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t, Pertenece p WHERE p.articulo = t AND p.categoria.id = :id");
        q.setParameter("id", cat.getId());
        return q.getResultList();
    }
    
        /**
         * Buscar un articulo
         * @param tema
         * @param descipcion
         * @return 
         */
    public List<ArticuloDonar> search(String tema, String descipcion){
        Query q = em.createQuery("SELECT t FROM ArticuloDonar t WHERE t.tema = :Tema AND t.descripcion LIKE :Descripcion");
        q.setParameter("Tema", tema);
        q.setParameter("Descripcion", descipcion);
        return q.getResultList();
    }
    
    /**
     * Consultar por los temas 
     * @return 
     */
    public List<String> getTemas(){
        Query q = em.createQuery("SELECT distinct(t.tema) FROM ArticuloDonar t");
        return q.getResultList();
    }
    
}
