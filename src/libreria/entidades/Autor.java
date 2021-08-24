package libreria.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Pablo
 */

@Entity
public class Autor {

    @Id
    private Integer id;
    private String nombre;

    public Autor() {
    }

    public Autor(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nombre=" + nombre + '}';
    }

    
    
    
    
}
