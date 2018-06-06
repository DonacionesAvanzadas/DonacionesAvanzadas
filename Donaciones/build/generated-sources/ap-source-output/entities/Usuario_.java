package entities;

import entities.ArticuloDonar;
import entities.Denuncia;
import entities.Quiere;
import entities.UsuariosBloqueados;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-05T21:20:49")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Boolean> estado;
    public static volatile ListAttribute<Usuario, Quiere> quiere;
    public static volatile SingularAttribute<Usuario, String> imagen;
    public static volatile ListAttribute<Usuario, UsuariosBloqueados> usuariosBloqueados;
    public static volatile SingularAttribute<Usuario, String> nombreUsuario;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, Integer> estrellas;
    public static volatile ListAttribute<Usuario, Denuncia> denuncia;
    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile SingularAttribute<Usuario, String> correo;
    public static volatile SingularAttribute<Usuario, String> tipoUsuario;
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile ListAttribute<Usuario, ArticuloDonar> articulo;
    public static volatile SingularAttribute<Usuario, Integer> denuncias;

}