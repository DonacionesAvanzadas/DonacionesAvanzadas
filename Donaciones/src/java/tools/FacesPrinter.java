package tools;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
public class FacesPrinter {
    public static void addMsg(String msg){
        addMsg(null, msg);
    }
    public static void addMsg(String location, String msg){
        FacesMessage facesMsg = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(location, facesMsg);
    }
}
