package libreria.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Pablo
 */

@Entity
public class Editorial {
    
    @Id
    private Integer id;
    private String nombre;

    public Editorial() {
    }

    public Editorial(Integer id, String nombre) {
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
        return "Editorial{" + "id=" + id + ", nombre=" + nombre + '}';
    }

    
    
}
