/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.ArticuloDonar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Wero
 */
@Named("listDonations")
@SessionScoped
public class ListDonationsManager implements Serializable {
    
    private List<ArticuloDonar> donations;
    
    public void init() {
        donations = new ArrayList<ArticuloDonar>();
    }
    
}
