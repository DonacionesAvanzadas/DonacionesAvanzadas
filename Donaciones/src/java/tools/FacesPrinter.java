package tools;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
public class FacesPrinter {
    /**
     * Añade un nuevo mensaje (solo texto)
     * @param msg el mensaje
     */
    public static void addMsg(String msg){
        addMsg(null, msg);
    }
    /**
     * añade un nuevo mensaje con todos los parametros
     * @param location de donde es
     * @param msg el mensaje
     */
    public static void addMsg(String location, String msg){
        FacesMessage facesMsg = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(location, facesMsg);
    }
}
