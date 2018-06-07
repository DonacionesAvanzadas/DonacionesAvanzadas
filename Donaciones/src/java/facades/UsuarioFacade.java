/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Usuario;
import java.util.List;
import javax.persistence.Query;
/**
 *
 * @author juanc
 */
public class UsuarioFacade extends AbstractFacade<Usuario> {
    
    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public List<Usuario> findByImagen(Object imagen){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.imagen = :imagen");
        q.setParameter("imagen", imagen);
        return q.getResultList();
    }
    
    public List<Usuario> findByNombre(Object nombre){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.nombre = :nombre");
        q.setParameter("nombre", nombre);
        return q.getResultList();
    }
    
    public List<Usuario> findByCorreo(Object correo){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.correo = :correo");
        q.setParameter("correo", correo);
        return q.getResultList();
    }
    
    public List<Usuario> findByNombreUsuario(Object nombreUsuario){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.nombreUsuario = :nombreUsuario");
        q.setParameter("nombreUsuario", nombreUsuario);
        return q.getResultList();
    }
    
    public List<Usuario> findByPassword(Object password){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.password = :password");
        q.setParameter("password", password);
        return q.getResultList();
    }
    
    public List<Usuario> findByEstrellas(Object estrellas){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.estrellas = :estrellas");
        q.setParameter("estrellas", estrellas);
        return q.getResultList();
    }
    
    public List<Usuario> findByDenuncias(Object denuncias){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.denuncias = :denuncias");
        q.setParameter("denuncias", denuncias);
        return q.getResultList();
    }
    
    public List<Usuario> findByTipoUsuario(Object tipoUsuario){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.tipoUsuario = :tipoUsuario");
        q.setParameter("tipoUsuario", tipoUsuario);
        return q.getResultList();
    }
    
    public List<Usuario> findByEstado(Object estado){
        Query q = em.createQuery("SELECT t FROM Usuario t WHERE t.estado = :estado");
        q.setParameter("estado", estado);
        return q.getResultList();
    }
    
}
