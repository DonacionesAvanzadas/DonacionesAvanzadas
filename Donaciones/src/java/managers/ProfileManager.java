/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.Usuario;
import java.util.List;
import entities.ArticuloDonar;
import facades.ArticuloDonarFacade;
import facades.UsuarioFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author juanc
 */
@ManagedBean(name="ProfileManager")
@SessionScoped
public class ProfileManager implements Serializable {
    
    @EJB
    private UsuarioFacade usuarios;
    @EJB
    private ArticuloDonarFacade articulos;
    
    private Usuario usuarioC;
    private List<ArticuloDonar> donaciones;
    
    public ProfileManager() {
        this.usuarioC = new Usuario();
        this.donaciones = null;
    }
    
    @PostConstruct
    public void init() {
        if(donaciones == null)
            donaciones = articulos.findByUsuario(usuarioC.getId());
    }
    
    public void setDonaciones(List<ArticuloDonar> donaciones){
        this.donaciones = donaciones;
    }
    
    public List<ArticuloDonar> getDonaciones(){
        return donaciones;
    }
    
    public void setUsuarioC(Usuario usuario) {
        this.usuarioC = usuario;
    }
    
    public Usuario getUsuarioC() {
        return this.usuarioC;
    }
    
    public void aumentarEstrellas() {
        int estrellas = usuarioC.getEstrellas();
        usuarioC.setEstrellas(estrellas++);
        usuarios.edit(usuarioC);
    }
    
}
