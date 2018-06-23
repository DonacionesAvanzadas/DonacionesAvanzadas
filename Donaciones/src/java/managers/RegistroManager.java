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
    
     /**
     * constructor de la clase, inicializa un usuario
     */
    public RegistroManager(){
       usuario = new Usuario();
    }
    /**
     * reteorna el objeto usuario
     * @return usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }
    /**
     * obtien un objeto tipo usurio par adespues asignarlo al objto del sistmea
     * @param usuario objeto tipo usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    /**
     *elimina los espacios que hay en la cadena
     * @param str una cadena
     * @return la cadena
     */
    private boolean isEmpty(String str){
        return str.trim().equals("");
    }
    /**
     * registra a un uaurio, obtiene nombre, nombre de usuario, correo y contraseña, en 
     * caso de que alguna propiedad falte se lanza un mensaje de advertencia.
     * Despues se comprueva que no este repetido el usuario, si lo esta mandea una
     * advertencia, si no prosigue a insertar al usuario junto con el valor de
     * estrellas predeterminadas 
     * @return retorna una aviso de "login"
     */
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
