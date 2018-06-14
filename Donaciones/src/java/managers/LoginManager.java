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
@Named("loginManager")
@SessionScoped
public class LoginManager implements Serializable {
    
    @EJB
    private UsuarioFacade ejb;
     
    private Usuario loginUser;
    private Usuario currentUser;
    private boolean logged = false;
    
    private void resetLoginUser(){
        loginUser = new Usuario();
        loginUser.setNombreUsuario("");
        loginUser.setPassword("");
    }
    
    public LoginManager(){
        resetLoginUser();
    }

    public Usuario getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(Usuario user) {
        this.loginUser = user;
    }

    public Usuario getCurrentUser() {
        return currentUser;
    }

    public boolean isLogged() {
        return logged;
    }
    
    public String doLogin(){
        List<Usuario> matches = ejb.findByNombreUsuario(loginUser.getNombreUsuario());
        if(ejb.checkLogin(loginUser) && !matches.isEmpty()){
            logged = true;
            
            currentUser = matches.get(0);
            
            resetLoginUser();
            return "index";
        } else {
            FacesPrinter.addMsg("Login no valido :c");
            return null;
        }
    }
    
    public String doLogout(){
        currentUser = null;
        logged = false;
        return "login";
    }

}
