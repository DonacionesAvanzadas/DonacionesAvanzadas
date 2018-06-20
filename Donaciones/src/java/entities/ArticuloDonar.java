/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;

/**
 *
 * @author Kevin Alan Martinez Virgen 14300260 8B1
 */
@Entity
@Table(name="articulo_donar")
public class ArticuloDonar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "sinopsis")
    private String sinopsis;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "tema")
    private String tema;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @OneToMany(mappedBy = "articulo")
    private List<Pertenece> pertenece;
    
    @OneToMany(mappedBy = "articulo")
    private List<Denuncia> denuncia;
    
    @OneToMany(mappedBy = "articulo")
    private List<Quiere> quiere;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Pertenece> getPertenece() {
        return pertenece;
    }

    public void setPertenece(List<Pertenece> pertenece) {
        this.pertenece = pertenece;
    }

    public List<Denuncia> getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(List<Denuncia> denuncia) {
        this.denuncia = denuncia;
    }

    public List<Quiere> getQuiere() {
        return quiere;
    }

    public void setQuiere(List<Quiere> quiere) {
        this.quiere = quiere;
    }
    
    

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public List<Pertenece> getArticle() {
        return pertenece;
    }

    public void setArticle(List<Pertenece> article) {
        this.pertenece = article;
    }

   
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticuloDonar)) {
            return false;
        }
        ArticuloDonar other = (ArticuloDonar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ArticuloDonar[ id=" + id + " ]";
    }
    
}
