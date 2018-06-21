/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;


import entities.ArticuloDonar;
import entities.Usuario;
import facades.ArticuloDonarFacade;
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
 * @author Arturo
 */
@Named("AddDonationsManager")
@SessionScoped
public class AddDonationsManager implements Serializable {
    @EJB
    private ArticuloDonarFacade ArticuloFacade;
    private ArticuloDonar Articulo;
    
    public AddDonationsManager(){
       Articulo = new ArticuloDonar();
    }

    public ArticuloDonar getArticulo() {
        return Articulo;
    }

    public void setArticulo(ArticuloDonar Articulo) {
        this.Articulo = Articulo;
    }

    private boolean isEmpty(String str){
        return str.trim().equals("");
    }
    public String PublicarArticulo()
    {
        boolean invalid = false;
        invalid |= isEmpty(Articulo.getSinopsis());
        invalid |= isEmpty(Articulo.getTema());
        invalid |= isEmpty(Articulo.getDescripcion());
        invalid |= isEmpty(Articulo.getImagen());
        
         if (invalid){
            FacesPrinter.addMsg("Por favor rellene todos los campos");
            return null;
        } 

         Articulo.getUsuario();
         ArticuloFacade.create(Articulo);
         Articulo = new ArticuloDonar();
         return "exito";
    }
 
            
    
}
