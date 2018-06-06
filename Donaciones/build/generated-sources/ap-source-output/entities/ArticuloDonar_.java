package entities;

import entities.Denuncia;
import entities.Pertenece;
import entities.Quiere;
import entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-05T21:20:49")
@StaticMetamodel(ArticuloDonar.class)
public class ArticuloDonar_ { 

    public static volatile SingularAttribute<ArticuloDonar, String> descripcion;
    public static volatile ListAttribute<ArticuloDonar, Denuncia> denuncia;
    public static volatile SingularAttribute<ArticuloDonar, String> tema;
    public static volatile ListAttribute<ArticuloDonar, Pertenece> pertenece;
    public static volatile ListAttribute<ArticuloDonar, Quiere> quiere;
    public static volatile SingularAttribute<ArticuloDonar, String> imagen;
    public static volatile SingularAttribute<ArticuloDonar, Usuario> usuario;
    public static volatile SingularAttribute<ArticuloDonar, Integer> id;
    public static volatile SingularAttribute<ArticuloDonar, String> sinopsis;

}