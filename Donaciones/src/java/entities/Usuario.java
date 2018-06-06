/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Kevin Alan Martinez Virgen 14300260 8B1
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "correo")
    private String correo;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "contrasena")
    private String password;
    @Column(name = "estrellas")
    private int estrellas;
    @Column(name = "denuncias")
    private int denuncias;
    @Column(name = "tipo_usuario")
    private String tipoUsuario;
    @Column(name = "estado")
    private boolean estado;
    @OneToMany(mappedBy="usuario")
    private List<UsuariosBloqueados> usuariosBloqueados;
    @OneToMany(mappedBy="usuario")
    private List<Denuncia> denuncia;
    @OneToMany(mappedBy="usuario")
    private List<Quiere> quiere;
    @OneToMany(mappedBy = "usuario")
    private List<ArticuloDonar> articulo;
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public int getDenuncias() {
        return denuncias;
    }

    public void setDenuncias(int denuncias) {
        this.denuncias = denuncias;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<UsuariosBloqueados> getUsuariosBloqueados() {
        return usuariosBloqueados;
    }

    public void setUsuariosBloqueados(List<UsuariosBloqueados> usuariosBloqueados) {
        this.usuariosBloqueados = usuariosBloqueados;
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

    public List<ArticuloDonar> getArticulo() {
        return articulo;
    }

    public void setArticulo(List<ArticuloDonar> articulo) {
        this.articulo = articulo;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usuario[ id=" + id + " ]";
    }
    
}
