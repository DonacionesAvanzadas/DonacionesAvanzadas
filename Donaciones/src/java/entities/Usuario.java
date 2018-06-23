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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * Retorna la propiedad imagen de la clase
     * @return imagen
     */
    public String getImagen() {
        return imagen;
    }
    /**
     * Recibe el valor de la propiedad imagen
     * @param imagen el valor que se va ha asignar
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    /**
     * Retorna la propiedad nombre de la clase
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Recibe el valor de la propiedad nombre
     * @param nombre el valor que se va ha asignar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Retorna la propiedad correo de la clase
     * @return correo
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * Recibe el valor de la propiedad correo
     * @param correo el valor que se va ha asignar
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /**
     * Retorna la propiedad nombreUsuario de la clase
     * @return nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    /**
     * Recibe el valor de la propiedad nombreUsuario
     * @param nombreUsuario el valor que se va ha asignar
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    /**
     * Retorna la propiedad password de la clase
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Recibe el valor de la propiedad password
     * @param password el valor que se va ha asignar
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Retorna la propiedad estrellas de la clase
     * @return estrellas
     */
    public int getEstrellas() {
        return estrellas;
    }
    /**
     * Recibe el valor de la propiedad estrellas
     * @param estrellas el valor que se va ha asignar
     */
    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }
    /**
     * Retorna la propiedad denuncias de la clase
     * @return denuncias
     */
    public int getDenuncias() {
        return denuncias;
    }
    /**
     * Recibe el valor de la propiedad denuncias
     * @param denuncias el valor que se va ha asignar
     */
    public void setDenuncias(int denuncias) {
        this.denuncias = denuncias;
    }
    /**
     * Retorna la propiedad tipoUsuario de la clase
     * @return tipoUsuario
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }
    /**
     * Recibe el valor de la propiedad tipoUsuario
     * @param tipoUsuario el valor que se va ha asignar
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    /**
     * Retorna la propiedad estado de la clase
     * @return estado
     */
    public boolean isEstado() {
        return estado;
    }
    /**
     * Recibe el valor de la propiedad estado
     * @param estado el valor que se va ha asignar
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    /**
     * Retorna una lista con los usuarios bloqueados
     * @return lista de usuariosBloqueados
     */
    public List<UsuariosBloqueados> getUsuariosBloqueados() {
        return usuariosBloqueados;
    }
    /**
     * Recibe una lista tipo UsuariosBloqueados y la asigna a la propiedad usuariosBloqueados
     * @param usuariosBloqueados lista tipo UsuariosBloqueados
     */
    public void setUsuariosBloqueados(List<UsuariosBloqueados> usuariosBloqueados) {
        this.usuariosBloqueados = usuariosBloqueados;
    }
    /**
     * Retorna una lista con las denuncias
     * @return lista de denuncia
     */
    public List<Denuncia> getDenuncia() {
        return denuncia;
    }
    /**
     * Recibe una lista tipo Denuncia y la asigna a la propiedad denuncia
     * @param denuncia lista tipo Denuncia
     */
    public void setDenuncia(List<Denuncia> denuncia) {
        this.denuncia = denuncia;
    }
    /**
     * Retorna una lista con los usuarios que quieren un libro
     * @return quiere lista tipo Quiere
     */
    public List<Quiere> getQuiere() {
        return quiere;
    }
    /**
     * Recibe una lista tipo Quiere y la asigna a la propiedad denuncia
     * @param quiere 
     */
    public void setQuiere(List<Quiere> quiere) {
        this.quiere = quiere;
    }
    /**
     * Retorna una lista con los articulos
     * @return articulo
     */
    public List<ArticuloDonar> getArticulo() {
        return articulo;
    }
    /**
     *  Recibe una lista tipo ArtuculoDonar y la asigna a la propiedad articulo
     * @param articulo 
     */
    public void setArticulo(List<ArticuloDonar> articulo) {
        this.articulo = articulo;
    }

    
    /**
     * Una funcion sobrecargada para calcular el hashCode del objeto serializable
     * @return hash de usuario
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    /**
     * Revisa que la id de usuario sea correcta 
     * @param object objeto tipo usuario
     * @return boolean, true es correcta la id, false incorrecta
     */
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
    /**
     * Muestra la id del usuario
     * @return un mensaje indicando la id del usuario
     */
    @Override
    public String toString() {
        return "entities.Usuario[ id=" + id + " ]";
    }
    
}
