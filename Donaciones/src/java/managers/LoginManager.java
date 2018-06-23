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
    
     public LoginManager(){//Se declara el constructor de la clase
        resetLoginUser();//El consutructo manda llamar está función
    }

    public Usuario getLoginUser() {//Se crea la función para obtener los datos del usuario, no recibe parametros, 
        return loginUser;//La función retorna el objeto donde se encuentran los datos del usuario
    }

    public void setLoginUser(Usuario user) {//Se crea la función de set en la que se g¿guardan los datos del usuario, recibe de parametros el usuario que quiere entrar
        this.loginUser = user;//La función iguala al objeto el dato que reciobio del nombre del usuario
    }

    public Usuario getCurrentUser() {//Se crea la función para obtener que usuario se encuentra
        return currentUser;//Retorna el objeto del usuario que esta dentro
    }

    public boolean isLogged() {//Se crea la función que dice si algún usuario ya se encuentra dentro del sistema
        return logged;//retorna un valor boleano de la variable para saber si un usuario ya se encuentra adentro
    }
    
    public String doLogin(){//Se crea la función para hacer el login, no recibe parametros
        List<Usuario> matches = ejb.findByNombreUsuario(loginUser.getNombreUsuario());//Busca en la BD si existe algún usuario con el usuario que trata de ingresar
        if(ejb.checkLogin(loginUser) && !matches.isEmpty()){//Hace una comparación si se encontró un usuario, si es positivo
            logged = true;//La variable logged la pone en verdadero para saber que ya hay un usuario connectado
            
            currentUser = matches.get(0);//Iguala el usuario que entra al primer resultado que se encontró
            
            resetLoginUser();//manda llamar la función de resetear los valores de login
            return "index";//retorna index que es a donde se va a redirigir al usuario
        } else {//Si no existe alguna coincidencia
            FacesPrinter.addMsg("Login no valido :c");//Manda el mensaje de que el login fue invalido
            return null;//retorna null 
        }
    }
    
    public String doLogout(){//Se crea la función para cerrar sesión, no recibe parametros
        currentUser = null;//Quita el usuario que ya esta dentro del sistema
        logged = false;//Pone la variable looged en falso para indicar que nadie se encuentra dentro
        return "login";//Retorna login que es a donde se va a redirigir al usuario
    }

}
