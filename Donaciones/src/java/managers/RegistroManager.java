package managers;

import entities.Usuario;
import facades.UsuarioFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import tools.FacesPrinter;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
@Named("registroManager")
@SessionScoped
public class RegistroManager implements Serializable {
    
    @EJB
    private UsuarioFacade ejb;
     
    private Usuario usuario;
    
    public RegistroManager(){
       usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private boolean isEmpty(String str){
        return str.trim().equals("");
    }
    
    public String registrar(){
        boolean invalid = false;
        invalid |= isEmpty(usuario.getNombre());
        invalid |= isEmpty(usuario.getNombreUsuario());
        invalid |= isEmpty(usuario.getCorreo());
        invalid |= isEmpty(usuario.getPassword());
        
        if (invalid){
            FacesPrinter.addMsg("Por favor rellene todos los campos");
            return null;
        } 
        
        if(!ejb.findByNombreUsuario(usuario.getNombreUsuario()).isEmpty()){
            FacesPrinter.addMsg("Ese nombre de usuario ya existe");
            return null;
        }
        
        usuario.setId(0);
        usuario.setEstado(true);
        usuario.setTipoUsuario("Regular");
        usuario.setEstrellas(0);
        usuario.setDenuncias(0);
        usuario.setImagen(""); //Ni idea cómo programar esto aún
        
        ejb.create(usuario);
        return "login";
    }

}
