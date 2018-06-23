/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Denuncia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author usuario
 */
@Stateless
public class DenunciaFacade extends AbstractFacade<Denuncia>{
    
    public DenunciaFacade() {
        super(Denuncia.class);
    }
    /**
     * retorna los articulos que esten denuciados
     * @param articulo
     * @return una lista con los articulos denunciados
     */
    public List<Denuncia> findByArticulo(Object articulo){
        Query q = em.createQuery("SELECT t FROM Denuncia t WHERE t.articulo = :articulo");
        q.setParameter("articulo", articulo);
        return q.getResultList();
    }
    /**
     * retorna los articulos denunciados por usuario
     * @param usuario
     * @return una lista con los articulos denunciados
     */
    public List<Denuncia> findByUsuario(Object usuario){
        Query q = em.createQuery("SELECT t FROM Denuncia t WHERE t.usuario = :usuario");
        q.setParameter("usuario", usuario);
        return q.getResultList();
    }
    
}
