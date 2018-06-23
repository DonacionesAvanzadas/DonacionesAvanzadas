/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Kevin Alan Martinez Virgen 14300260 8B1
 */
@Entity
public class UsuariosBloqueados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "fecha_sancion")
    private Date date;
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

   /**
     * Retorna la propiedad id de la clase
     * @return id
     */
    public Integer getId() {
        return id;
    }
    /**
     * Recibe el valor de la propiedad id
     * @param id el valor que se va ha asignar
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Retorna la propiedad date de la clase
     * @return date
     */
    public Date getDate() {
        return date;
    }
    /**
     * Recibe el valor de la propiedad date
     * @param date el valor que se va ha asignar
     */
    public void setDate(Date date) {
        this.date = date;
    }
    /**
     * Retorna la propiedad usuario de la clase
     * @return usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }
    /**
     * Recibe el valor de la propiedad usuario
     * @param usuario el valor que se va ha asignar
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    /**
     * Una funcion sobrecargada para calcular el hashCode del objeto serializable
     * @return hash de usuariosBloqueados
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    /**
     * Revisa que la id de usuario bloqueado sea correcta 
     * @param object objeto tipo usuarioBloqueados
     * @return boolean, true es correcta la id, false incorrecta
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosBloqueados)) {
            return false;
        }
        UsuariosBloqueados other = (UsuariosBloqueados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    /**
     * Muestra la id del usuario bloqueado
     * @return un mensaje indicando la id del usuario bloqueado
     */
    @Override
    public String toString() {
        return "entities.UsuariosBloqueados[ id=" + id + " ]";
    }
    
}
