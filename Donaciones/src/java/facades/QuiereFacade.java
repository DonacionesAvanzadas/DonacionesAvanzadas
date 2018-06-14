/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Quiere;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author usuario
 */
@Stateless
public class QuiereFacade extends AbstractFacade<Quiere>{
    
    public QuiereFacade() {
        super(Quiere.class);
    }
    
    public List<Quiere> findByArticulo(Object articulo){
        Query q = em.createQuery("SELECT t FROM Quiere t WHERE t.articulo = :articulo");
        q.setParameter("articulo", articulo);
        return q.getResultList();
    }
    
    public List<Quiere> findByUsuario(Object usuario){
        Query q = em.createQuery("SELECT t FROM Quiere t WHERE t.usuario = :usuario");
        q.setParameter("usuario", usuario);
        return q.getResultList();
    }
    
    public List<Quiere> findByEstado(Object estado) {
        Query q = em.createQuery("SELECT t FROM Quiere t WHERE t.estado = :estado");
        q.setParameter("estado", estado);
        return q.getResultList();
    }
    
    public List<Quiere> findByEncuentro(Object encuentro) {
        Query q = em.createQuery("SELECT t FROM Quiere t WHERE t.encuentro = :encuentro");
        q.setParameter("encuentro", encuentro);
        return q.getResultList();
    }
    
}
