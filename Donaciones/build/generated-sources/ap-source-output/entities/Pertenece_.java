package entities;

import entities.ArticuloDonar;
import entities.Categoria;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-05T21:20:49")
@StaticMetamodel(Pertenece.class)
public class Pertenece_ { 

    public static volatile SingularAttribute<Pertenece, Categoria> categoria;
    public static volatile SingularAttribute<Pertenece, Integer> id;
    public static volatile SingularAttribute<Pertenece, ArticuloDonar> articulo;

}