/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.UsuariosBloqueados;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
/**
 *
 * @author juanc
 */
@Stateless
public class UsuariosBloqueadosFacade extends AbstractFacade<UsuariosBloqueados> {
    
    public UsuariosBloqueadosFacade() {
        super(UsuariosBloqueados.class);
    }
    
    /**
     * Busca en la tabla de usuarios bloqueado por el nombre de usuario 
     * @param usuario
     * @return 
     */
    public List<UsuariosBloqueados> findByUsuario(Object usuario){
        Query q = em.createQuery("SELECT t FROM UsuariosBloqueados t WHERE t.usuario = :usuario");
        q.setParameter("usuario", usuario);
        return q.getResultList();
    }
    
    /**
     * buscar usuarios bloqueados por la fecha 
     * @param date
     * @return 
     */
    public List<UsuariosBloqueados> findByDate(Object date){
        Query q = em.createQuery("SELECT t FROM UsuariosBloqueados t WHERE t.date = :date");
        q.setParameter("date", date);
        return q.getResultList();
    }
    
}
