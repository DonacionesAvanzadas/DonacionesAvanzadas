/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.ArticuloDonar;
import facades.ArticuloDonarFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author kevin
 */
@ManagedBean(name="DonationManager")
@SessionScoped
public class DonationManager implements Serializable{
    @EJB
    private ArticuloDonarFacade ejb;
    private ArticuloDonar articulo;

    @PostConstruct
    public void init() {
        if(articulo==null)
            articulo = new ArticuloDonar();
    }
    
    public ArticuloDonar getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloDonar articulo) {
        this.articulo = articulo;
    }
    
    public void readArticulo(){
        this.articulo = ejb.find(this.articulo.getId());
    }
}
