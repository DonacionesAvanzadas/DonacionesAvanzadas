package entities;

import entities.ArticuloDonar;
import entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-05T21:20:49")
@StaticMetamodel(Quiere.class)
public class Quiere_ { 

    public static volatile SingularAttribute<Quiere, Boolean> estado;
    public static volatile SingularAttribute<Quiere, String> encuentro;
    public static volatile SingularAttribute<Quiere, Usuario> usuario;
    public static volatile SingularAttribute<Quiere, Integer> id;
    public static volatile SingularAttribute<Quiere, ArticuloDonar> articulo;

}