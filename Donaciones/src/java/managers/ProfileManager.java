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
    /**
     * constructor de la clase, inicaliza la propiedad e usuarioC y pone en 
     * null la propiedad donaciones
     */
    public ProfileManager() {
        this.usuarioC = new Usuario();
        this.donaciones = null;
    }
    /**
     * validacion del usuario, si es null se obtendra la id del usuario
     */
    @PostConstruct
    public void init() {
        if(donaciones == null)
            donaciones = articulos.findByUsuario(usuarioC.getId());
    }
    /**
     * obtiene una lista tipo articuloDonar para asiganr el valor a la propiedad donaciones
     * @param donaciones lista tipo articuloDonar
     */
    public void setDonaciones(List<ArticuloDonar> donaciones){
        this.donaciones = donaciones;
    }
    /**
     * retrona una lista tipo articuloDonar con las donaciones
     * @return donaciones lista tipo articuloDonar
     */
    public List<ArticuloDonar> getDonaciones(){
        return donaciones;
    }
    /**
     * obtiene un objeto tipo usuario para asignarlo a la propiedad usuarioC
     * @param usuario objeeto tipo usuario
     */
    public void setUsuarioC(Usuario usuario) {
        this.usuarioC = usuario;
    }
    /**
     * retorna la propiedad usurioC
     * @return usurioC
     */
    public Usuario getUsuarioC() {
        return this.usuarioC;
    }
    /**
     * aumenta las estrellas. Primero obtiene las estrellas del usuario para
     * despues aumentar la cantidad y por ultimo modificar la calificacion 
     */
    public void aumentarEstrellas() {
        int estrellas = usuarioC.getEstrellas();
        usuarioC.setEstrellas(estrellas++);
        usuarios.edit(usuarioC);
    }
    
}
