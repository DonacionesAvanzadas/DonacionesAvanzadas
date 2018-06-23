/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.ArticuloDonar;
import entities.Categoria;
import entities.Pertenece;
import entities.Quiere;
import entities.Usuario;
import facades.ArticuloDonarFacade;
import facades.CategoriaFacade;
import facades.PerteneceFacade;
import facades.QuiereFacade;
import facades.UsuarioFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Wero 
 */
@ManagedBean(name="listDonations")
@SessionScoped
public class ListDonationsManager implements Serializable{
    
    @EJB
    private ArticuloDonarFacade articulos;
    @EJB
    private CategoriaFacade categorias;
    @EJB
    private PerteneceFacade pertenece;
    @EJB
    private UsuarioFacade usuario;
    @EJB
    private QuiereFacade quiereFacade;
    @Inject LoginManager loginManager;
    
    private List<ArticuloDonar> donations;
    private Integer categoria;
    private String nombre;    
    private List<Usuario> quieren;
    
    
    @PostConstruct
    public void init() {
        
        if(donations==null)
        donations = articulos.findAll();
        
    }
    public List<ArticuloDonar> getDonations(){
        return donations;
    }
    public List<Categoria> getTemas(){
        return categorias.findAll();
    }
    /**
     * busca por categoria y retorna los articulos
     * @return retorna un mensaje
     */
    public String search(){
        Categoria c = new Categoria();
        c.setId(this.categoria);
        if(nombre.trim().equals("") && categoria!=null){
            this.donations = articulos.getByCategoria(c);
        }else if(!nombre.trim().equals("") && categoria==null)
            donations = articulos.findByDescripcion('%'+nombre+'%');
        else if(!nombre.trim().equals("") && categoria!=null){
            donations = articulos.findByDescripcion('%'+nombre+'%');
            List<ArticuloDonar> articulo_categoria = articulos.getByCategoria(c);
            for(ArticuloDonar x: articulo_categoria){
                if(!donations.contains(x))
                    donations.add(x);
            }
        }else donations = articulos.findAll();
        
        return "list_donations";
    }
    
  private ArticuloDonar current;

    public ArticuloDonar getCurrent() {
        return current;
    }

    public void setCurrent(ArticuloDonar current) {
        this.current = current;
    }
  /**
   * determina quien quierre un articulo
   * @param id 
   */
    public void setCurr(int id){
         for(ArticuloDonar x: articulos.findAll()){
             if(x.getId() == id) current = x;
         }
         quieren = usuario.getByCategoria(current);
    }
    
    public Integer getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public List<Usuario> getQuieren(){
        return quieren;
    }

    public void setQuieren(List<Usuario> quieren) {
        this.quieren = quieren;
    }
    /**
     * indica que un articulo lo quiere un usuario
     * @return un mensaje
     */
    public String loQuiero(){
        Quiere quiere = new Quiere();
        quiere.setArticuloDonar(this.current);
        quiere.setUsuario(loginManager.getCurrentUser());
        quiere.setEncuentro("");
        quiere.setEstado(false);
        quiereFacade.create(quiere);
        return "index";
    }
    
    
}
