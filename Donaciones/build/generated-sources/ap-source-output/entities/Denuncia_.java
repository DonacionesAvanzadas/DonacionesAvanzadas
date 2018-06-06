package entities;

import entities.ArticuloDonar;
import entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-05T21:20:49")
@StaticMetamodel(Denuncia.class)
public class Denuncia_ { 

    public static volatile SingularAttribute<Denuncia, Usuario> usuario;
    public static volatile SingularAttribute<Denuncia, Integer> id;
    public static volatile SingularAttribute<Denuncia, ArticuloDonar> articulo;

}