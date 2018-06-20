/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.ArticuloDonar;
import facades.ArticuloDonarFacade;
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
    private List<ArticuloDonar> donations;
    private String tema;
    private String nombre;    
    
    @PostConstruct
    public void init() {
        if(donations==null)
        donations = articulos.findAll();
    }
    public List<ArticuloDonar> getDonations(){
        return donations;
    }
    public List<String> getTemas(){
        return articulos.getTemas();
    }
    public String search(){
        if(nombre==null && tema!=null)
            donations = articulos.findByTema(tema);
        else if(nombre!=null && tema==null)
            donations = articulos.findByDescripcion('%'+nombre+'%');
        else if(nombre!=null && tema!=null)
            donations = articulos.search(tema,'%'+nombre+'%');
        else donations = articulos.findAll();
        
        return "list_donations";
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
