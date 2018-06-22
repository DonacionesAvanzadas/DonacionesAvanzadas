package managers;

import entities.Usuario;
import facades.ArticuloDonarFacade;
import facades.UsuarioFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Yo Merengues =D
 */
@ManagedBean(name="listTopDonations")
@SessionScoped
public class TopManager implements Serializable{
    @EJB
    private UsuarioFacade uf;
    
    public List<Usuario> getUsuariosDonadores() {
        return usuariosDonadores;
    }
    
    
    @PostConstruct
    public void init() {
        
        if(usuariosDonadores == null)
        usuariosDonadores = uf.findAll();
        Usuario pasa;
        int size = usuariosDonadores.size();
        for(int i=0; i<size - 1; i++){
            for(int j=0; j<size - 1; j++){
                if(usuariosDonadores.get(j).getEstrellas() < usuariosDonadores.get(j+1).getEstrellas()){
                    pasa = usuariosDonadores.get(j); 
                    usuariosDonadores.set(j, usuariosDonadores.get(j+1));
                    usuariosDonadores.set(j+1, pasa);
                }
            }
        }
        if(size >= 10){
            usuariosDonadores = usuariosDonadores.subList(0, 9);
        }
    }
    
    private List<Usuario> usuariosDonadores = null; 
}
