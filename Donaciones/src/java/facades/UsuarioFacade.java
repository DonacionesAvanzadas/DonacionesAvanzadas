/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.ArticuloDonar;
import entities.Categoria;
import entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
/**
 *
 * @author juanc
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    
    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    /**
     * Verifica que el login sea correcto
     * @param usuario
     * @return 
     */
    public boolean checkLogin(Usuario usuario){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.nombreUsuario = :nombreUsuario AND t.password = :password");
        q.setParameter("nombreUsuario", usuario.getNombreUsuario());
        q.setParameter("password", usuario.getPassword());
        return !q.getResultList().isEmpty();
    }
    
    /**
     * Busca por la imagen de la tabla usuario
     * @param imagen
     * @return 
     */
    public List<Usuario> findByImagen(Object imagen){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.imagen = :imagen");
        q.setParameter("imagen", imagen);
        return q.getResultList();
    }
    
    /**
     * Busca de la tabla usuario por el nombre
     * @param nombre
     * @return 
     */
    public List<Usuario> findByNombre(Object nombre){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.nombre = :nombre");
        q.setParameter("nombre", nombre);
        return q.getResultList();
    }
    
    /**
     * Busca en la tabla usuario por el correo 
     * @param correo
     * @return 
     */
    public List<Usuario> findByCorreo(Object correo){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.correo = :correo");
        q.setParameter("correo", correo);
        return q.getResultList();
    }
    
    /**
     * Busca en la tabla de usuario por el nombre de usuario
     * @param nombreUsuario
     * @return 
     */
    public List<Usuario> findByNombreUsuario(Object nombreUsuario){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.nombreUsuario = :nombreUsuario");
        q.setParameter("nombreUsuario", nombreUsuario);
        return q.getResultList();
    }
    
    /**
     * Busca en la tabla de usuario por el password
     * @param password
     * @return 
     */
    public List<Usuario> findByPassword(Object password){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.password = :password");
        q.setParameter("password", password);
        return q.getResultList();
    }
    
    /**
     * Busca en la tabla de usuario por el numero de estrellas 
     * @param estrellas
     * @return 
     */
    public List<Usuario> findByEstrellas(Object estrellas){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.estrellas = :estrellas");
        q.setParameter("estrellas", estrellas);
        return q.getResultList();
    }
    
    
    /**
     * busca en la tala de usuario segun las denucias 
     * @param denuncias
     * @return 
     */
    public List<Usuario> findByDenuncias(Object denuncias){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.denuncias = :denuncias");
        q.setParameter("denuncias", denuncias);
        return q.getResultList();
    }
    
    /**
     * 
     * Busca en la tabla de usuario segun el tipo de usuario
     * @param tipoUsuario
     * @return 
     */
    public List<Usuario> findByTipoUsuario(Object tipoUsuario){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.tipoUsuario = :tipoUsuario");
        q.setParameter("tipoUsuario", tipoUsuario);
        return q.getResultList();
    }
    
    /**
     * Busca en la tabla de usuario segun el estado 
     * @param estado
     * @return 
     */
    public List<Usuario> findByEstado(Object estado){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.estado = :estado");
        q.setParameter("estado", estado);
        return q.getResultList();
    }
    
    /**
     * Busca en la tabla de usuario segun la categoria 
     * @param art
     * @return 
     */
    public List<Usuario> getByCategoria(ArticuloDonar art){
        Query q = em.createQuery("SELECT t FROM Usuario t, Quiere p WHERE p.usuario = t AND p.articulo.id = :id");
        q.setParameter("id", art.getId());
        return q.getResultList();
    }
}
