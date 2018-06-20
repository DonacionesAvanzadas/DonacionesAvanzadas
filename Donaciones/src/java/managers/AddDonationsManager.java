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
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import tools.FacesPrinter;
/**
 *
 * @author Arturo
 */
@Named("addDonationsManager")
@ViewScoped
public class AddDonationsManager implements Serializable {
    @EJB
    private ArticuloDonarFacade ArticuloFacade;
    private ArticuloDonar Articulo;
    private List<Integer> categorias;
    
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
        if(str==null)return false;
        return str.trim().equals("");
    }
    public String publicarArticulo()
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

         Usuario usuario = new Usuario();
         usuario.setId(1);
         Articulo.setUsuario(usuario);
         ArticuloFacade.create(Articulo);
         return "list_donations";
    }

    public List<Integer> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Integer> categorias) {
        this.categorias = categorias;
    }
        
}
