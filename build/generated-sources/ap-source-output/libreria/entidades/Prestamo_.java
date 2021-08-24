package libreria.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import libreria.entidades.Libro;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-23T21:06:26")
@StaticMetamodel(Prestamo.class)
public class Prestamo_ { 

    public static volatile SingularAttribute<Prestamo, Date> fecha;
    public static volatile SingularAttribute<Prestamo, Date> devolucion;
    public static volatile SingularAttribute<Prestamo, Libro> libro;
    public static volatile SingularAttribute<Prestamo, Integer> id;

}