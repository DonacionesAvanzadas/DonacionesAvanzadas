/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.ArticuloDonar;
import entities.Categoria;
import entities.Pertenece;
import facades.ArticuloDonarFacade;
import facades.CategoriaFacade;
import facades.PerteneceFacade;
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
    private List<ArticuloDonar> donations;
    private Categoria categoria;
    private String nombre;    
    
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
    public String search(){
        
        if(nombre==null && categoria!=null){
            this.donations = getByCategoria();
        }else if(nombre!=null && categoria==null)
            donations = articulos.findByDescripcion('%'+nombre+'%');
        else if(nombre!=null && categoria!=null){
            donations = articulos.findByDescripcion('%'+nombre+'%');
            List<ArticuloDonar> articulo_categoria = getByCategoria();
            for(ArticuloDonar x: articulo_categoria){
                if(!donations.contains(x))
                    donations.add(x);
            }
        }else donations = articulos.findAll();
        
        return "list_donations";
    }

    private List<ArticuloDonar> getByCategoria(){
        List<Pertenece>categoria_producto;
        categoria_producto = pertenece.findByCategoria(categoria.getId());
        List<ArticuloDonar> articulos_categoria = new ArrayList<>();
        categoria_producto.forEach((x)->articulos_categoria.add(x.getArticulo()));
        return donations;
    }
    
    public Categoria getTema() {
        return categoria;
    }

    public void Categoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
