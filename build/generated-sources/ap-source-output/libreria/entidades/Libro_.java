package libreria.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-23T21:06:26")
@StaticMetamodel(Libro.class)
public class Libro_ { 

    public static volatile SingularAttribute<Libro, Editorial> editorial;
    public static volatile SingularAttribute<Libro, Integer> prestados;
    public static volatile SingularAttribute<Libro, Integer> ejemplares;
    public static volatile SingularAttribute<Libro, Integer> isbn;
    public static volatile SingularAttribute<Libro, String> titulo;
    public static volatile SingularAttribute<Libro, Integer> año;
    public static volatile SingularAttribute<Libro, Autor> autor;

}