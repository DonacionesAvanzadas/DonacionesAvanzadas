package managers;

import entities.Categoria;
import facades.CategoriaFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import tools.FacesPrinter;

/**
 *
 * @author Yo merengues
 */
@Named("categoriaManager")
@SessionScoped
public class AddCategoriaManager implements Serializable{
    @EJB
    private CategoriaFacade ejb;
    
    private Categoria categoria;

    public AddCategoriaManager(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    private boolean isEmpty(String str){
        return str.trim().equals("");
    }
    
    public String addCategoria(){
        if (isEmpty("Favor de ingresar el texto correctamente")){
            FacesPrinter.addMsg("Por favor rellene todos los campos");
            return null;
        } 
        ejb.create(categoria);
        return "index";
    }
    
    
}
